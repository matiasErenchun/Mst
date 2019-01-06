import java.util.ArrayList;

public class Nodo
{
    private int padre;
    private int nodo;
    private Double x;
    private Double y;
    private ArrayList<Integer> conexiones;

    public Nodo(int nodo,Double x, Double y)
    {
        this.nodo=nodo;
        this.padre=nodo;
        this.x = x;
        this.y = y;
        this.conexiones= new ArrayList<>();
    }

    public Double getX()
    {
        return this.x;
    }

    public Double getY()
    {
        return this.y;
    }
    @Override
    public String toString()
    {
        return "nodo:"+this.nodo+" Padre:"+this.getPadre()+" x: "+this.getX()+" y: "+this.getY();
    }

    public void agregarConexion(int arista)
    {
        this.conexiones.add(arista);
    }

    public ArrayList<Integer> getConexiones()
    {
        return this.conexiones;
    }

    public void mostrarConexiones()
    {
        System.out.println(this.conexiones.toString());
    }

    public int getNodo()
    {
        return this.nodo;
    }

    public int getPadre()
    {
        return this.padre;
    }

    public int setPadre(int  nuevoPadre)
    {
        this.padre=nuevoPadre;
        return this.getPadre();
    }



}
