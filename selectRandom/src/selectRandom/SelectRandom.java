/*
  Aviel Resnick
  Problem Set 18.5

  Returns a random number form a given array of integers.
*/

package selectRandom;
import java.util.*;

public class SelectRandom {
    public static void main() {
        int[] array = new int[] {1,2,3,4,5};
        System.out.println(selectRandom(array));
    }

    public static int selectRandom(int[] array) {
        Random generator = new Random();
        int arrayLength = array.length;
        int index = generator.nextInt(arrayLength);

        return(array[index]);
    }
}
