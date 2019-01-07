import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Mst
{

    private ArrayList<Arista> aristasMst;
    private int cantidadNodos;
    private Nodo[]nodos;

    public Mst(int cantidadNodos, Nodo [] nodos)
    {
        this.nodos=nodos;
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
            if(this.buscar(auxArista.getNodo1())!=this.buscar(auxArista.getNodo2()))
            {
                this.union(auxArista.getNodo1(),auxArista.getNodo2());
                this.aristasMst.add(auxArista);


            }

        }

        return this.aristasMst;
    }

    public void union(int x, int y)
    {
        Nodo nodox=this.nodos[x];
        this.nodos[y].setPadre(nodox.getPadre());
    }

    public int buscar(int x)
    {
        if(this.nodos[x].getPadre()!=x)
        {
            this.nodos[x].setPadre(this.buscar(this.nodos[x].getPadre()));

        }

        return this.nodos[x].getPadre();
    }

    public void mostrarAristasMst()
    {
        int k=0;
        for (Arista a:this.aristasMst)
        {
            Nodo nodo1 = this.nodos[a.getNodo1()];
            Nodo nodo2= this.nodos[a.getNodo2()];
            System.out.println(nodo1.getX()+" "+nodo1.getY()+" "+nodo2.getX()+" "+nodo2.getY()+" "+a.getPeso());
        }
    }

}
