import edu.princeton.cs.algs4.StdDraw;
public class BalonDeBasket 
{
    private Double coordenadaX;
    private Double coordenadaY;
    private Double vectorX;
    private Double vectorY;
    private final Double gravedad = 0.98 ;

    public void draw()
    {
        StdDraw.setPenRadius(0.03);
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.point(this.coordenadaX, this.coordenadaY);
    }
    public void collision(double deltaT)
    {
        if(this.coordenadaY <= 0.00)
        {
            this.vectorY = this.vectorY*-1;
        }
    }

    public boolean fueraDelCampo()
    {
        return this.coordenadaX < 0 || this.coordenadaX > 1 || this.coordenadaY > 1;
    }
    public void move(double deltaT)
    {
        this.coordenadaX = this.coordenadaX+this.vectorX*deltaT;
        this.coordenadaY = this.coordenadaY+this.vectorY * deltaT +((this.gravedad*deltaT*deltaT)/2);
        this.vectorY -= this.gravedad * deltaT;
        deltaT ++;
    }
    public BalonDeBasket(Double coordenadaX, Double coordenadaY, Double vectorX, Double vectorY)
    {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.vectorX = vectorX;
        this.vectorY = vectorY;
    }
    public static void main(String[] args) 
    {
        //
        BalonDeBasket prueba = new BalonDeBasket(0.1, 0.9,0.0,0.0);
        prueba.move(0.4);
        assert prueba.coordenadaY != 0.9:"no hubo movimiento";
        prueba.coordenadaY = 2.0;
        assert prueba.fueraDelCampo() == true: "no quedó fuera del campo";
        prueba.coordenadaY = 0.0;
        prueba.vectorY = -0.2;
        prueba.collision(0.004);
        assert prueba.vectorY == 0.2:"la colisión no cambió la dirección de la velocidad";

    }
}
