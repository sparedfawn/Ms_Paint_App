package paint;

import exceptions.PositionOutOfBounds;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import tools.*;


public class PaintController
{
    @FXML
    private Canvas canvas;

    @FXML
    private TextField painterSize;

    @FXML
    private ColorPicker colorPicker;

    public GraphicsContext stroke;

    private ToolBox tools = new ToolBox();

    //metoda odpowiedzialna za obsluge akcji wykonywanych na plutnie
    public void initialize()
    {
        stroke = canvas.getGraphicsContext2D();
        //w przypadku gdy klikniemy przycisk myszy lub go przeciagniemy i puscimy tworzac figure
        canvas.setOnMousePressed(event ->
        {
            //gdy mamy wybrane jako narzedzie pedzel (Brush)
            if(tools.getIfBrushSelected())
            {
                try
                {
                    stroke.setFill(colorPicker.getValue());
                    Brush brush = new Brush(Double.parseDouble(painterSize.getText()), new Point(event.getX(), event.getY()));
                    brush.drawWithBrush(stroke, canvas);
                }
                catch (PositionOutOfBounds e)
                {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }

            //gdy mamy wybrane jako narzedzie gumke (Eraser)
            if(tools.getIfEraserSelected())
            {
                try
                {
                    Eraser eraser = new Eraser(Double.parseDouble(painterSize.getText()), new Point(event.getX(), event.getY()));
                    eraser.clearWithEraser(stroke, canvas);
                }
                catch(PositionOutOfBounds e)
                {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }

            //gdy mamy wybrane jako narzedzie olowek (Pencil)
            if(tools.getIfPencilSelected())
            {
                try
                {
                    Pencil pencil = new Pencil(new Point(event.getX(), event.getY()));
                    pencil.drawWithPencil(stroke, canvas);
                }
                catch (PositionOutOfBounds e)
                {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }

            //gdy mamy wybrane jako narzedzie wypelnienie obszaru (Fill)
            if(tools.getIfFillSelected())
            {
                stroke.setFill(colorPicker.getValue());
                Fill filling = new Fill(new Point(event.getX(), event.getY()));
                filling.fillShape(stroke, canvas);
            }

            //gdy mamy wybrane jako narzedzie prostokat (Rectangle)
            if(tools.getIfRectangleSelected())
            {
                canvas.setOnMouseReleased(event1 ->
                {
                    if(tools.getIfRectangleSelected())
                    {
                        try
                        {
                            stroke.setStroke(colorPicker.getValue());
                            stroke.setLineWidth(Double.parseDouble(painterSize.getText()));
                            Rectangle rectangle = new Rectangle(new Point(event.getX(), event.getY()), new Point(event1.getX(), event1.getY()));
                            rectangle.drawRectangle(stroke, canvas);
                        }
                        catch(PositionOutOfBounds e)
                        {
                            e.printStackTrace();
                            System.out.println(e.getMessage());
                        }
                    }
                });
            }

            //gdy mamy wybrane jako narzedzie okrag (Circle)
            if(tools.getIfCircleSelected())
            {
                canvas.setOnMouseReleased(event1 ->
                {
                    if(tools.getIfCircleSelected())
                    {
                        try
                        {
                            stroke.setStroke(colorPicker.getValue());
                            stroke.setLineWidth((Double.parseDouble(painterSize.getText())));
                            Circle circle = new Circle(new Point(event.getX(), event.getY()), new Point(event1.getX(), event1.getY()));
                            circle.drawCircle(stroke, canvas);
                        }
                        catch(PositionOutOfBounds e)
                        {
                            e.printStackTrace();
                            System.out.println(e.getMessage());
                        }
                    }
                });
            }

            //gdy mamy wybrane jako narzedzie linie (Line)
            if(tools.getIfLineSelected())
            {
                canvas.setOnMouseReleased(event1 ->
                {
                    if(tools.getIfLineSelected())
                    {
                        try
                        {
                            stroke.setStroke(colorPicker.getValue());
                            stroke.setLineWidth(Double.parseDouble(painterSize.getText()));
                            Line line = new Line(new Point(event.getX(), event.getY()), new Point(event1.getX(), event1.getY()));
                            line.drawLine(stroke, canvas);
                        }
                        catch(PositionOutOfBounds e)
                        {
                            e.printStackTrace();
                            System.out.println(e.getMessage());
                        }
                    }
                });
            }
        });


        //w przypadku gdy przycisk myszy jest przeciagany bez puszczania go
        canvas.setOnMouseDragged(event ->
        {
            //gdy mamy wybrane jako narzedzie gumke (Eraser)
            if(tools.getIfEraserSelected())
            {
                try
                {
                    Eraser eraser = new Eraser(Double.parseDouble(painterSize.getText()), new Point(event.getX(), event.getY()));
                    eraser.clearWithEraser(stroke, canvas);
                }
                catch(PositionOutOfBounds e)
                {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }

            //gdy mamy wybrane jako narzedzie pedzel (Brush)
            if(tools.getIfBrushSelected())
            {
                try
                {
                    stroke.setFill(colorPicker.getValue());
                    Brush brush = new Brush(Double.parseDouble(painterSize.getText()), new Point(event.getX(), event.getY()));
                    brush.drawWithBrush(stroke, canvas);
                }
                catch (PositionOutOfBounds e)
                {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }

            //gdy mamy wybrane jako narzedzie olowek (Pencil)
            if(tools.getIfPencilSelected())
            {
                try
                {
                    Pencil pencil = new Pencil(new Point(event.getX(), event.getY()));
                    pencil.drawWithPencil(stroke, canvas);
                }
                catch (PositionOutOfBounds e)
                {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }
        });
    }



    /* metoda wywowywana w przypadku wybrania opcji "Save as JPEG" w menu "File"
    metoda wywoluje statyczna metode z klasy Save */
    public void jpgOnSave()
    {
        Save.saveToJPG(canvas);
    }

    /* metoda wywowywana w przypadku wybrania opcji "Save as PNG" w menu "File"
    metoda wywoluje statyczna metode z klasy Save */
    public void pngOnSave()
    {
        Save.saveToPNG(canvas);
    }

    //metoda wywowywana w przypadku wybrania opcji "New Blank Canvas" w menu "File"
    public void onSelectNewBlankCanvas()
    {
        stroke.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    //metoda wywowywana w przypadku wybrania opcji "New Colored Canvas" w menu "File"
    public void onSelectNewColoredCanvas()
    {
        stroke.setFill(colorPicker.getValue());
        stroke.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    //metoda wywowywana w przypadku wybrania opcji "Exit" w menu "File"
    public void onExit()
    {
        Platform.exit();
    }


    /*metoda wywowywana w przypadku wybrania pedzla jako uzywane narzedzie
    metoda wywoluje wirtualna metode*/
    public void onSelectBrush()
    {
        ToolBox temp = new Brush();
        temp.toolSelected();
        tools = temp;
    }

    /*metoda wywowywana w przypadku wybrania gumki jako uzywane narzedzie
    metoda wywoluje wirtualna metode*/
    public void onSelectEraser()
    {
        ToolBox temp = new Eraser();
        temp.toolSelected();
        tools = temp;
    }

    /*metoda wywowywana w przypadku wybrania olowka jako uzywane narzedzie
    metoda wywoluje wirtualna metode*/
    public void onSelectPencil()
    {
        ToolBox temp = new Pencil();
        temp.toolSelected();
        tools = temp;
    }

    /*metoda wywowywana w przypadku wybrania wypelnienia obszaru jako uzywane narzedzie
    metoda wywoluje wirtualna metode*/
    public void onSelectFill()
    {
        ToolBox temp = new Fill();
        temp.toolSelected();
        tools = temp;
    }

    /*metoda wywowywana w przypadku wybrania linii jako uzywane narzedzie
    metoda wywoluje wirtualna metode*/
    public void onSelectLine()
    {
        ToolBox temp = new Line();
        temp.toolSelected();
        tools = temp;
    }

    /*metoda wywowywana w przypadku wybrania okregu jako uzywane narzedzie
    metoda wywoluje wirtualna metode*/
    public void onSelectCircle()
    {
        ToolBox temp = new Circle();
        temp.toolSelected();
        tools = temp;
    }

    /*metoda wywowywana w przypadku wybrania prostokata jako uzywane narzedzie
    metoda wywoluje wirtualna metode*/
    public void onSelectRectangle()
    {
        ToolBox temp=new Rectangle();
        temp.toolSelected();
        tools = temp;
    }
}
