package exceptions;

//klasa z ktorej dziedzicza wszystkie wyjatki programu
public class PaintExceptions extends Exception
{
    public PaintExceptions()
    {

    }

    public PaintExceptions(String msg)
    {
        super(msg);
    }
}
