
public class dijkstra
{
    private static Matriz m;
    private static String v;
    private static String nodos;
    private static String densidad;
    private static String repeticiones;
    public static void main(String[] args)
    {
        boolean b=false;
        if(args.length==4)
        {
            String v=args[0];
            nodos=args[1];
            String densidad=args[2];
            String repeticiones=args[3];
            b=true;
        }
        else
        {
             nodos=args[0];
             densidad=args[1];
             repeticiones=args[2];
        }
        int nNodos=Integer.parseInt(nodos);
        float dDensidad =Float.parseFloat(densidad);
        Double rep =Double.parseDouble(repeticiones);
        m=new Matriz();
        long tiempoMedio=0;
        for (int i = 0; i < rep ; i++)
        {
            tiempoMedio+=m.correr(nNodos,  dDensidad, b);
        }
        Double nTMedio=tiempoMedio/rep;
        nTMedio=nTMedio/1e-9;
        System.out.println("tiempo medio que demora el algoritmos :"+nTMedio);




    }


}
