import org.code.theater.*;
import org.code.media.*;

/*
 * Represents the ImagesFilters
 */
public class ImageFilter extends ImagePlus {

  /*
   * Calls the superclass constructor to initialize pixels
   */
  
  
   public ImageFilter(String filename) {
    super(filename);
  }

  /*
   * Mirrors the image vertically by swapping pixel values between left and right sides.
   * This effect creates a reflection along the vertical center of the image.
   */
  public void mirrorVertical() {
   
    Pixel[][] pixels = getImagePixels();
  for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length/2; col++) {
        Pixel leftPixel = pixels[row][col];
        Pixel rightPixel = pixels[row][pixels[0].length-col-1];

        leftPixel.setRed(rightPixel.getRed());
        leftPixel.setGreen(rightPixel.getGreen());
        leftPixel.setBlue(rightPixel.getBlue());
      }
    }


    
  }
  
  

  /*
   * Applies a saturation filter to the image
   */
  public void saturate(int factor) {

   Pixel[][] pixels = getImagePixels();

    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[row].length; col++) {
        Pixel pixel = pixels[row][col];

        // Calculate the grayscale average
        int average = (pixel.getRed() + pixel.getBlue() + pixel.getGreen()) / 3;

        int adjustedGrayscale = average + (average - 255) * factor;

        // Calculate the new red, green, and blue values
        int newRed = 2 * adjustedGrayscale - pixel.getRed();
        int newGreen = 2 * adjustedGrayscale - pixel.getGreen();
        int newBlue = 2 * adjustedGrayscale - pixel.getBlue();
        
        //Set the Values to 255 if they are greater than 255 
        if (newRed > 255) {
          newRed = 255;
        } else if (newRed < 0) {
          newRed = 0;
        }
        if (newGreen > 255) {
          newGreen = 255;
        } else if (newGreen < 0) {
          newGreen = 0;
        }
        if (newBlue > 255) {
          newBlue = 255;
        } else if (newBlue < 0) {
          newBlue = 0;
        }
        
        // Update the pixel's color values
        pixel.setRed(newRed);
        pixel.setBlue(newBlue);
        pixel.setGreen(newGreen);
      }
    }
  }

public void adjustContrast(int multiplier) {
    /* 
     *  Get the pixels from the image, and traverse the 2D array of Pixel objects.
     * Multiply the red, green, and blue values of each Pixel by the multiplier,
     * and set the color values to the result.
     * 
     */

    Pixel[][] pixels = getPixelsFromImage();

    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];

        int currentRed = currentPixel.getRed();
        int currentGreen = currentPixel.getGreen();
        int currentBlue = currentPixel.getBlue();

        int newRed = (int)((multiplier * currentRed));
        int newGreen = (int)((multiplier * currentGreen));
        int newBlue = (int)((multiplier * currentBlue));
      
        //multiplies the colors by a multiplier to ncrease the contrast.

if (newRed > 255) {
  newRed = 255;
}
        if (newGreen > 255) {
          newGreen = 255;
        }

        if (newBlue > 255) {
          newBlue = 255;
        }
        //caps the rgb as 255 because rgb cannot go above a value of 255.
        
        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
        //sets the new pixel as the 
      }
    }
    
  }
  /*
   * Mirrors the image horizontally by getting the top pixels and putting it onto the bottom.
   * It works the same as the mirrorVertical method, but instead of changing the columns,
   * it changes the rows.
   */
   public void mirrorHorizontal() {
    Pixel[][] pixels = getImagePixels();
    for (int row = 0; row < pixels.length / 2; row++) {
        for (int col = 0; col < pixels[0].length; col++) {
            Pixel topPixel = pixels[row][col];
            Pixel bottomPixel = pixels[pixels.length - row - 1][col];

            topPixel.setRed(bottomPixel.getRed());
            topPixel.setGreen(bottomPixel.getGreen());
            topPixel.setBlue(bottomPixel.getBlue());
        }
    }
}
}