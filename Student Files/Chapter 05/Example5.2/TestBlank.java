// Example 5.2

import images.APImage;
import images.Pixel;
import java.util.Scanner;

public class TestBlank{

   public static void main(String[]args){
      Scanner reader = new Scanner(System.in);
      APImage image = new APImage(150, 150);
      image.draw();
      int y = image.getHeight() / 2;
      for (int x = 0; x <= image.getWidth(); x++)
         image.setPixel(x, y, new Pixel(255, 0, 0));
      System.out.print("Press return to continue:");
      reader.nextLine();
      image.draw();
   } 
}
      