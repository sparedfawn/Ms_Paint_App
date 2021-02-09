package exceptions;

//wyjatek wyrzucany w przypadku proby uzycia ktoregos z narzedzi poza granicami canvy
public class PositionOutOfBounds extends PaintExceptions
{
    public PositionOutOfBounds(String msg)
    {
        super(msg);
    }
}
