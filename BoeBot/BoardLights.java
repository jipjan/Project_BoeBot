import TI.*;
import java.awt.Color;

/**
 * Write a description of class RGB_Board here.
 * 
 * @author Zwen van Erkelens 
 * @version (a version number or a date)
 */
public class BoardLights
{
    Color color = Color.getHSBColor((float)0.03, 1, 1);
    
    public void alarmLights()
    {
        stopAllLights();
            while(true)
        {
            BoeBot.rgbSet(0, color.getRed(), color.getGreen(), color.getBlue());
            BoeBot.rgbSet(1, 0, 0, 0);
            BoeBot.rgbSet(2, color.getRed(), color.getGreen(), color.getBlue());
            BoeBot.rgbSet(3, color.getRed(), color.getGreen(), color.getBlue());
            BoeBot.rgbSet(4, 0, 0, 0);
            BoeBot.rgbSet(5, color.getRed(), color.getGreen(), color.getBlue());
            BoeBot.rgbShow();
            
            BoeBot.wait(500);
            
            stopAllLights();
            
            BoeBot.wait(500);
        }
    }
    
    public void rightLights()
    {
        stopAllLights();
            while(true)
        {
            BoeBot.rgbSet(0, color.getRed(), color.getGreen(), color.getBlue());
            BoeBot.rgbSet(1, 0, 0, 0);
            BoeBot.rgbSet(2, 0, 0, 0);
            BoeBot.rgbSet(3, 0, 0, 0);
            BoeBot.rgbSet(4, 0, 0, 0);
            BoeBot.rgbSet(5, color.getRed(), color.getGreen(), color.getBlue());
            BoeBot.rgbShow();
            
            BoeBot.wait(500);
            
            stopAllLights();
            
            BoeBot.wait(500);
        }
    }
    
    public void leftLights()
    {
        stopAllLights();
            while(true)
        {
            BoeBot.rgbSet(0, 0, 0, 0);
            BoeBot.rgbSet(1, 0, 0, 0);
            BoeBot.rgbSet(2, color.getRed(), color.getGreen(), color.getBlue());
            BoeBot.rgbSet(3, color.getRed(), color.getGreen(), color.getBlue());
            BoeBot.rgbSet(4, 0, 0, 0);
            BoeBot.rgbSet(5, 0, 0, 0);
            BoeBot.rgbShow();
            
            BoeBot.wait(500);
            
            stopAllLights();
            
            BoeBot.wait(500);
        }
    }
    
    public void stopAllLights()
    {
        BoeBot.rgbSet(0, 0, 0, 0);
        BoeBot.rgbSet(1, 0, 0, 0);
        BoeBot.rgbSet(2, 0, 0, 0);
        BoeBot.rgbSet(3, 0, 0, 0);
        BoeBot.rgbSet(4, 0, 0, 0);
        BoeBot.rgbSet(5, 0, 0, 0);
        BoeBot.rgbShow();
    }
}
