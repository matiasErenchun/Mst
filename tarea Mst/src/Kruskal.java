import java.util.StringTokenizer;

public class Kruskal
{
    private static Matriz m;
    private static String v;
    private static String nodos;
    private static String densidad;
    private static String repeticiones;
    public static void main(String[] args)
    {
        /*
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
        */
        Double rep=new Double(10);
        m=new Matriz();
        Long tiempoMedio=new Long(0);
        Double largomedio= new Double(0);
        for (int i = 0; i < 10 ; i++)
        {
            String salida=m.correr(100,  (float)0.5, false);
            StringTokenizer toke= new StringTokenizer(salida);
            String tiempo=toke.nextToken();
            System.out.println("t "+tiempo);
            String largo=toke.nextToken();
            System.out.println("l "+largo);
            tiempoMedio+=Long.parseLong(tiempo);
            largomedio+=Double.parseDouble(largo);
        }
        Double nTMedio=tiempoMedio/rep;
        largomedio=largomedio/rep;
        nTMedio=nTMedio;
        System.out.println("tiempo medio que demora el algoritmos :"+nTMedio +", con largo medio del MSt de :"+largomedio);




    }


}
