public class Arista implements Comparable<Arista>
{
    private int nodo1;
    private int nodo2;
    private Double peso;

    public Arista(int nodo1, int nodo2, Double peso)
    {
        this.nodo1 = nodo1;
        this.nodo2 = nodo2;
        this.peso = peso;
    }

    public int getNodo1()
    {
        return this.nodo1;
    }

    public int getNodo2()
    {
        return this.nodo2;
    }

    public Double getPeso()
    {
        return this.peso;
    }

    @Override
    public String toString()
    {
        return " nodo1:"+this.nodo1+" nodo2:"+this.nodo2+" peso:"+this.peso;

    }



    public int compareTo(Arista o)
    {
        if (this.getPeso().compareTo(o.getPeso())<0)
        {
            return -1;
        }
        else
        {
            if(this.getPeso().compareTo(o.getPeso())==0)
            {
                return 0;
            }
            else
            {
                return 1;
            }

        }

    }
}
