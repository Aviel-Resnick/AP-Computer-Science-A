/*
  Aviel Resnick
   Compute the Summation assuming int range (a,b)
   Week 24
   AP Comp Sci
*/

public class Summation {
    private static int low,high,result; //VARIABLES USED IN THIS CLASS.
    private static int total = 0;

    //CONSTRUCTOR METHOD 2
    public Summation(int a, int b){
        low = a;
        high = b;
        result = sum(low,high);
    }

    private static int sum(int a, int b){
        if (a < b) {
            total += a;
            a++;
            return(sum(a,b));
        }

        else {
            total += b;
        }

        return(total);
    }

    public String toString(){
        String a = "The recursive sum is: " + result;
        return a;
    }
}
