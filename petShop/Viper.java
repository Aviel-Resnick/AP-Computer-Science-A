/*
  Aviel Resnick
  Part of the AbstrPets Project
  2/20
*/

public class Viper extends Snake
 {
   private int stripes;

   public Viper(String snakeName, int snakeLength,int numberStripes)
   {
      super(snakeName,snakeLength); //invokes the superclass concrete constructor in AbstrPets
      stripes = numberStripes;
   }
   public int getStripes()
   {
      return stripes;
   }
  public String toString()
   {
   return (super.toString() + " and has " + stripes + " number of stripes");
   }
   public String speak()
   {
      return "Hiss"; // overwrites the sound defined in snake
   }
   public String move()
   {
      return "Slither";
   }
}
