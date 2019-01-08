import java.util.ArrayList;
import java.util.PriorityQueue;

public class Mst
{

    private ArrayList<Arista> aristasMst;
    private int cantidadNodos;
    private int[]nodos;

    public Mst(int cantidadNodos)
    {
        this.nodos= new int[cantidadNodos];
        this.cargarNodos();
        this.cantidadNodos=cantidadNodos;
        this.aristasMst = new ArrayList<Arista>();

    }


    public ArrayList<Arista> getMst( ArrayList<Arista> aristasG)
    {

        PriorityQueue<Arista>aristasGrafo = new PriorityQueue<>();
        for (Arista a:aristasG)
        {
            aristasGrafo.add(a);
        }

        while(this.cantidadNodos-1>this.aristasMst.size())
        {
            Arista auxArista=aristasGrafo.poll();
            if(!this.conectados(auxArista.getNodo1(),auxArista.getNodo2()))
            {
                this.union(auxArista.getNodo1(),auxArista.getNodo2());
                this.aristasMst.add(auxArista);

            }

        }

        return this.aristasMst;
    }

    public void cargarNodos()
    {
        for (int i = 0; i < this.nodos.length; i++)
        {
            this.nodos[i]=i;

        }
    }

    public void union(int x, int y)
    {
        int auxX=this.nodos[x];
        int auxY=this.nodos[y];
        this.nodos[x]=auxY;
        for (int i = 0; i <this.nodos.length ; i++)
        {
            if (this.nodos[i]==auxX)
            {
                this.nodos[i]=auxY;
            }
        }
    }

    public boolean conectados(int x, int y)
    {
        return  this.nodos[x]==this.nodos[y];
    }



}
