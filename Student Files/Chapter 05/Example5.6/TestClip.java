/*

Example 5.6

You can reset maximum heap size when running the program if you run out of memory
for large sound clips, as follows:

java -Xmx<new size>m <program file name>

where <new size> is an integer.  Example:

java -Xmx128m TestClip

allows up to 128 megabytes of heap space.
*/

import sounds.*;
import java.util.Scanner;

public class TestClip{

   public static void main(String[]args){
      APSoundClip clip = new APSoundClip(0);
      clip.draw();
    }
   
}
      