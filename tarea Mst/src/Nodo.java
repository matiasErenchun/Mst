public class Nodo
{
    private Double x;
    private Double y;

    public Nodo(Double x, Double y)
    {
        this.x = x;
        this.y = y;
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
        return "x: "+this.getX()+" y: "+this.getY();
    }
}
