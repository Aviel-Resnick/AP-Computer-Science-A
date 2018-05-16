/*
  Aviel Resnick
  Part of the AbstrPets Project
  2/20
*/

public class Penguin extends Bird
{
  private String color;
  public Penguin(String birdName, int birdHeight, int birdWingSpan,String birdColor)
  {
     super(birdName,birdHeight,birdWingSpan);//invokes the superclass concrete constructor in AbstrPets
     color = birdColor;
  }
  public String getColor()
  {
     return color;
  }
 public String toString()
  {
  return (super.toString() + " and has a color of " + color);
  }
  public String speak()
  {
     return "Hi there!";// takes precedence over original
  }
  public String move()
  {
     return "Dance"; // hehe
  }

}
