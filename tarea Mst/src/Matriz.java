import java.lang.reflect.Array;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class Matriz
{
    private String[][]miMatriz ;
    private Nodo[] nodos;



    public Matriz(int cNodos, float densidad)
    {

        this.miMatriz = new String[cNodos][cNodos];
        this.nodos = new Nodo[cNodos];
        this.generarNodos();
        this.mostrarNodos();
        this.Llenar("0");
        this.cargarAristas(cNodos,densidad);
        this.cargarConeccionesNodos();
        this.reducirBosque(0);
        this.mostrarNodos();
        this.mostrarMatriz();
        this.listaAristas();
    }

    public void Llenar(String relleno)
    {
        int i=0;
        while(i<this.miMatriz.length)
        {
            int j=0;
            while(j<this.miMatriz.length)
            {
                if(i==j && i< miMatriz.length-1 && i>0)
                {
                    this.miMatriz[i][j] = relleno;
                    this.miMatriz[i][j+1] = "1";
                    this.miMatriz[i][j-1] = "1";
                    j+=2;
                }
                else
                {
                    this.miMatriz[i][j] = relleno;
                    j++;
                }

            }
            i++;
        }
        this.miMatriz[0][1] = "1";
        this.miMatriz[this.miMatriz.length-1][this.miMatriz.length-2] = "1";
    }

    public void generarNodos()
    {
        int i=0;
        while(i<this.nodos.length)
        {
            Double x=this.generarValor();
            double y=this.generarValor();
            Nodo auxNodo= new Nodo(i,x,y);
            this.nodos[i]=auxNodo;
            i++;
        }
    }

    public void mostrarNodos()
    {

        for (int i = 0; i <this.nodos.length ; i++)
        {
            System.out.println(this.nodos[i].toString());
        }
    }

    public Double generarValor()
    {
        SecureRandom random = new SecureRandom();
        Double respuesta=null;
        random =null;
        try {
            random = SecureRandom.getInstance("SHA1PRNG", "SUN");
            random.nextBytes(new byte[1]);
            respuesta = random.nextDouble();

        }
        catch (NoSuchAlgorithmException e)
        {
             e.printStackTrace();
        }
        catch (NoSuchProviderException e)
        {
            e.printStackTrace();
        }

        return respuesta;
    }

    public void mostrarMatriz()
    {
        int i=0;
        while(i<this.miMatriz.length)
        {
            int j=0;
            while(j<this.miMatriz.length)
            {
                System.out.print(this.miMatriz[i][j]+" ");
                j++;
            }
            System.out.println(" ");
            i++;
        }
    }

    public Nodo[] getNodos()
    {
        return this.nodos;
    }


    // carga la matriz con  la cantidad de aristas resultantes  de densidad*((n*(n-1))/2)
    public void cargarAristas(int n ,float densidad)
    {
        Float fAristas = densidad*((n*(n-1))/2);
        int aristas = fAristas.intValue();
        System.out.println("aristas "+aristas);
        int i=(this.miMatriz.length)-1;
        int fila;
        int columna;
        while (i<aristas)
        {
            fila=this.generarValorInt(this.miMatriz.length);
            columna=this.generarValorInt(this.miMatriz.length);
            if(this.miMatriz[fila][columna]!="1" && fila!=columna )
            {
                this.miMatriz[fila][columna]="1";
                this.miMatriz[columna][fila]="1";
                i++;
            }
        }
    }

    // genera un valor pseudo aleatorio entre 0 y la cantidad de nodos
    public int generarValorInt(int nodos)
    {
        SecureRandom random = new SecureRandom();
        Integer respuesta=null;
        random =null;
        try {
            random = SecureRandom.getInstance("SHA1PRNG", "SUN");
            random.nextBytes(new byte[1]);
            respuesta = random.nextInt(nodos);

        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchProviderException e)
        {
            e.printStackTrace();
        }

        return respuesta;
    }

    // regresa una lista de aristas  sina ristas repetidas ( se copia la diagonal inferior)
    public ArrayList<Arista> listaAristas()
    {
        ArrayList<Arista>aristas = new ArrayList<>();
        int i=0;
        while(i<this.miMatriz.length)
        {
            int j=0;
            while(j<i)
            {
                if(this.miMatriz[i][j].equals("1"))
                {
                    Double peso=this.calcularPeso(i,j);
                    Arista arista=new Arista(i,j,peso);

                    aristas.add(arista);

                }
                j++;
            }
            i++;
        }
        for (Nodo noddo:this.nodos)
        {
            System.out.println("nodo"+noddo.getNodo());
            noddo.mostrarConexiones();
        }
        for (int j = 0; j <aristas.size() ; j++)
        {
            System.out.println("j:"+j+aristas.get(j).mostrar());
        }

        return aristas;
    }

    // cargas en la lista de conecciones del nodo con cuales otros nodos  esta conectado.
    public void cargarConeccionesNodos()
    {
        int i=0;
        while(i<this.miMatriz.length)
        {
            int j=0;
            while(j<this.miMatriz.length)
            {
                if(this.miMatriz[i][j].equals("1"))
                {
                    this.getNodo(i).agregarConexion(j);
                }
                j++;
            }
            i++;
        }
    }

    // ados dos  los dos nodos de una arista  calcula el peso  de la arista, que no es mas que la distancia euclidiana entre estos dos nodos.
    public Double calcularPeso(int nodo1, int nodo2)
    {
        Nodo nod1=this.getNodo(nodo1);
        Nodo nod2 = this.getNodo(nodo2);
        Double suma1=nod2.getX()- nod1.getX();
        Double suma2=nod2.getY()- nod1.getY();

        Double cuadradoX=Math.pow(suma1,2);
        Double cuadradoY=Math.pow(suma2,2);

        Double suma=cuadradoX+cuadradoY;
        Double peso = Math.sqrt(suma);

        return peso;
    }

    // este metodo retorna el nodo en el indis indicado.
    public Nodo getNodo(int index)
    {
        return this.nodos[index];
    }

    public int union(int x,int y)
    {
        int raiz=this.getNodo(x).getPadre();
        this.getNodo(y).setPadre(raiz);
        return this.getNodo(y).getPadre();
    }

    public void reducirBosque(int nodo)
    {
        for (Nodo noodo:this.nodos)
        {
            for (int intNodo:noodo.getConexiones())
            {
                if(noodo.getPadre()!= this.getNodo(intNodo).getPadre())
                {
                    this.union(noodo.getPadre(),intNodo);
                }
            }
        }
    }

}
