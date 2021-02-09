package paint;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import java.io.File;
import javafx.scene.canvas.Canvas;

public class Save
{
    private static int i = 0, j = 0;

    //metoda zapisujaca obraz jako plik JPEG
    public static void saveToJPG(Canvas canvas)
    {
        try
        {
            i++;
            Image screenshot = canvas.snapshot(null,null);
            ImageIO.write(SwingFXUtils.fromFXImage(screenshot, null), "png", new File("paint" + i + ".jpg"));
        }
        catch(Exception e)
        {
            System.out.println("Failed to save image: " + e);
        }
    }

    //metoda zapisujaca obraz jako plik PNG
    public static void saveToPNG(Canvas canvas)
    {
        try
        {
            j++;
            Image screenshot = canvas.snapshot(null,null);
            ImageIO.write(SwingFXUtils.fromFXImage(screenshot, null), "png", new File("paint" + j + ".png"));
        }
        catch(Exception e)
        {
            System.out.println("Failed to save image: " + e);
        }
    }
}
