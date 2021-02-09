package tools;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import paint.Point;

import java.util.LinkedList;
import java.util.Queue;

public class Fill extends ToolBox
{
    private WritableImage snap;
    private Color oldColor;
    private Point startingPixel;

    public Fill()
    {

    }

    public Fill(Point painter)
    {
        startingPixel = new Point(painter.getX(), painter.getY());
    }


    //nadpis metody wirtualnej z klasy ToolBox
    @Override
    public void toolSelected()
    {
        super.setIfBrushSelected(false);
        super.setIfEraserSelected(false);
        super.setIfFillSelected(true);
        super.setIfLineSelected(false);
        super.setIfPencilSelected(false);
        super.setIfCircleSelected(false);
    }

    //metoda wykonujaca funkcjonalnosc wypelnienia obszaru
    public void fillShape(GraphicsContext stroke, Canvas canvas)
    {
        snap = stroke.getCanvas().snapshot(null, null);
        boolean[][] isPainted = new boolean[(int)canvas.getHeight()][(int)canvas.getWidth()];
        oldColor = snap.getPixelReader().getColor((int) startingPixel.getX(), (int) startingPixel.getY());

        Queue<Point> pointQueue = new LinkedList<Point>();
        pointQueue.add(startingPixel);
        while(!pointQueue.isEmpty())
        {
            Point p = pointQueue.remove();
            if(p.getX() >= 0   &&   p.getX() < canvas.getWidth()   &&   p.getY() >= 0   &&   p.getY() < canvas.getHeight())
            {
                if(snap.getPixelReader().getColor((int) p.getX(), (int) p.getY()).equals(oldColor)   &&   !isPainted[(int)p.getY()][(int)p.getX()])
                {
                    stroke.fillRect(p.getX(), p.getY(), 1, 1);
                    isPainted[(int)p.getY()][(int)p.getX()] = true;
                    pointQueue.add(new Point(p.getX() + 1, p.getY()));
                    pointQueue.add(new Point(p.getX() - 1, p.getY()));
                    pointQueue.add(new Point(p.getX(), p.getY() + 1));
                    pointQueue.add(new Point(p.getX(), p.getY() - 1));
                }
            }
        }
    }
}
