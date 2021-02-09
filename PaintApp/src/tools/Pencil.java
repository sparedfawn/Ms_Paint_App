package tools;

import exceptions.PositionOutOfBounds;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import paint.Point;

public class Pencil extends ToolBox
{
    private Point pencilPosition, mousePosition;
    private double pencilSize;
    
    public Pencil()
    {
        
    }

    public Pencil(Point painter)
    {
        pencilSize = 5;
        mousePosition = painter;
        this.pencilPosition = new Point(painter.getX() - pencilSize / 2, painter.getY() - pencilSize / 2);
    }


    //nadpis metody wirtualnej z klasy ToolBox
    @Override
    public void toolSelected()
    {
        super.setIfBrushSelected(false);
        super.setIfEraserSelected(false);
        super.setIfFillSelected(false);
        super.setIfLineSelected(false);
        super.setIfPencilSelected(true);
        super.setIfCircleSelected(false);
    }

    //metoda wykonujaca funkcjonalnosc rysowania przy uzyciu olowka
    public void drawWithPencil(GraphicsContext stroke, Canvas canvas) throws PositionOutOfBounds
    {
        if(mousePosition.getX() < 0   ||   mousePosition.getY() < 0   || mousePosition.getX() > canvas.getWidth()   ||   mousePosition.getY() > canvas.getHeight())
            throw new PositionOutOfBounds("Tried to draw out of bounds.");
        stroke.setFill(Color.BLACK);
        stroke.fillRoundRect(pencilPosition.getX(), pencilPosition.getY(), pencilSize, pencilSize, pencilSize, pencilSize);
    }
}
