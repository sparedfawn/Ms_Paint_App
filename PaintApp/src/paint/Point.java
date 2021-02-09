package paint;

public class Point
{
    private double x, y;

    public Point(double x, double y)
    {
        this.x=x;
        this.y=y;
    }

    //metody pobierajace wartosci wspolrzednych
    public double getX()
    {
        return this.x;
    }

    public double getY()
    {
        return this.y;
    }
}
