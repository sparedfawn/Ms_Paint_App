package tools;

import exceptions.PositionOutOfBounds;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import paint.Point;

public class  Brush extends ToolBox
{
    private Point brushPosition, mousePosition;
    private double brushSize;

    public Brush()
    {

    }

    public Brush(double brushSize, Point painter)
    {
        this.brushSize = brushSize;
        mousePosition = painter;
        this.brushPosition = new Point(painter.getX() - brushSize / 2, painter.getY() - brushSize / 2);
    }


    //nadpis metody wirtualnej z klasy ToolBox
    @Override
    public void toolSelected()
    {
        super.setIfBrushSelected(true);
        super.setIfEraserSelected(false);
        super.setIfFillSelected(false);
        super.setIfLineSelected(false);
        super.setIfPencilSelected(false);
        super.setIfCircleSelected(false);
    }

    //metoda wykonujaca funkcjonalnosc rysowania przy uzyciu pedzla
    public void drawWithBrush(GraphicsContext stroke, Canvas canvas) throws PositionOutOfBounds
    {
        if(mousePosition.getX() < 0   ||   mousePosition.getY() < 0   || mousePosition.getX() > canvas.getWidth()   ||   mousePosition.getY() > canvas.getHeight())
            throw new PositionOutOfBounds("Tried to draw out of bounds.");
        stroke.fillRoundRect(brushPosition.getX(), brushPosition.getY(), brushSize, brushSize, brushSize, brushSize);
    }
}
