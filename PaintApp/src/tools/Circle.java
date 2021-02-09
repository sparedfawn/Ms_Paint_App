package tools;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import paint.Point;
import exceptions.PositionOutOfBounds;

import static java.lang.StrictMath.abs;

public class Circle extends ToolBox
{
    private Point A, B;

    public Circle()
    {

    }

    public Circle(Point A, Point B)
    {
        this.A = A;
        this.B = B;
    }


    //nadpis metody wirtualnej z klasy ToolBox
    @Override
    public void toolSelected()
    {
        super.setIfBrushSelected(false);
        super.setIfEraserSelected(false);
        super.setIfFillSelected(false);
        super.setIfLineSelected(false);
        super.setIfPencilSelected(false);
        super.setIfCircleSelected(true);
    }

    //metoda wykonujaca funkcjonalnosc tworzenia okregu
    public void drawCircle(GraphicsContext stroke, Canvas canvas) throws PositionOutOfBounds
    {
        if(B.getX() < 0   ||   B.getY() < 0   ||   B.getX() > canvas.getWidth()   ||   B.getY() > canvas.getHeight())
            throw new PositionOutOfBounds("End of circle out of bounds.");

        if(A.getX() < B.getX()  &&   A.getY() < B.getY())
        {
            stroke.strokeOval(A.getX(), A.getY(), abs(A.getX() - B.getX()), abs(A.getY() - B.getY()));
        }
        else if(A.getX() < B.getX()   &&   A.getY() > B.getY())
        {
            stroke.strokeOval(A.getX(), B.getY(), abs(A.getX() - B.getX()), abs(A.getY() - B.getY()));
        }
        else if(A.getX() > B.getX()   &&   A.getY() > B.getY())
        {
            stroke.strokeOval(B.getX(), B.getY(), abs(A.getX() - B.getX()), abs(A.getY() - B.getY()));
        }
        else if(A.getX() > B.getX()   &&   A.getY() < B.getY())
        {
            stroke.strokeOval(B.getX(), A.getY(), abs(A.getX() - B.getX()), abs(A.getY() - B.getY()));
        }
    }
}
