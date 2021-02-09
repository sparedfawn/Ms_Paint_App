package tools;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import paint.Point;
import exceptions.PositionOutOfBounds;

public class Line extends ToolBox
{
    private Point A, B;

    public Line()
    {

    }

    public Line(Point A, Point B)
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
        super.setIfLineSelected(true);
        super.setIfPencilSelected(false);
        super.setIfCircleSelected(false);
    }

    //metoda wykonujaca funkcjonalnosc tworzenia linii
    public void drawLine(GraphicsContext stroke, Canvas canvas) throws PositionOutOfBounds
{
    if(B.getX() < 0   ||   B.getY() < 0   ||   B.getX() > canvas.getWidth()   ||   B.getY() > canvas.getHeight())
        throw new PositionOutOfBounds("End of line out of bounds.");

    stroke.strokeLine(A.getX(), A.getY(), B.getX(), B.getY());
}
}
