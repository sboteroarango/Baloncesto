import edu.princeton.cs.algs4.StdDraw;
import java.util.LinkedList;
import edu.princeton.cs.algs4.StdRandom;

class CampoBaloncesto
{
    private int cantidadBalones;
    public CampoBaloncesto(int cantidadDeBalones)
    {
        this.cantidadBalones = cantidadDeBalones;
    }

    public void runSimulation()
    {   
        LinkedList<BalonDeBasket> bolsa = new LinkedList<>();
        for(int i = 0; i < this.cantidadBalones; i++)
        {
            BalonDeBasket ball = new BalonDeBasket(StdRandom.uniform(), StdRandom.uniform(), StdRandom.uniform(-0.4, 0.4),0.0 );
            bolsa.add(ball);
        }
        StdDraw.enableDoubleBuffering();
        while(true)
        {
        StdDraw.clear();
        for (BalonDeBasket ball : bolsa) 
        {
            ball.move(0.003);
            StdDraw.setPenRadius(0.01);
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.line(0.985, 0.0, 0.015, 0.0);
            ball.draw();
            ball.collision(0.003);
            if(ball.fueraDelCampo())
            {
                bolsa.remove(ball);
                break;
            }
        }
        StdDraw.show();
        StdDraw.pause(1);
        }
    }
    public static void main(String[] args) 
    {
        CampoBaloncesto campo = new CampoBaloncesto(20);
        campo.runSimulation();
    }

}
