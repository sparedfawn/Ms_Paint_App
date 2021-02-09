package tools;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import paint.Point;
import exceptions.PositionOutOfBounds;

public class Eraser extends ToolBox
{
    private Point eraserPosition, mousePosition;
    private double eraserSize;

    public Eraser()
    {

    }

    public Eraser(double eraserSize, Point painter)
    {
        this.eraserSize = eraserSize;
        mousePosition = painter;
        eraserPosition = new Point(painter.getX() - eraserSize / 2, painter.getY() - eraserSize / 2);
    }


    //nadpis metody wirtualnej z klasy ToolBox
    @Override
    public void toolSelected()
    {
        super.setIfBrushSelected(false);
        super.setIfEraserSelected(true);
        super.setIfFillSelected(false);
        super.setIfLineSelected(false);
        super.setIfPencilSelected(false);
        super.setIfCircleSelected(false);
    }

    //metoda wykonujaca funkcjonalnosc wycierania przy uzyciu gumki
    public void clearWithEraser(GraphicsContext stroke, Canvas canvas) throws PositionOutOfBounds
    {
        if(mousePosition.getX() < 0   ||   mousePosition.getY() < 0   || mousePosition.getX() > canvas.getWidth()   ||   mousePosition.getY() > canvas.getHeight())
            throw new PositionOutOfBounds("Tried to clear area out of bounds.");
        stroke.clearRect(eraserPosition.getX(), eraserPosition.getY(), eraserSize, eraserSize);
    }
}
