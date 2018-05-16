/*
  Aviel Resnick
  Part of the AbstrPets Project
  2/20
*/

public class Siamese extends Cat
{
  private int teeth;

  public Cat(String catName, int numberWhiskers, boolean isCatStriped, int numTeeth)
  {
     super(catName,numberWhiskers,isCatStriped);//invokes the superclass concrete constructor in AbstrPets
     teeth = numTeeth;
  }
  public int getTeeth()
  {
     return teeth;
  }
 public String toString()
  {
  return (super.toString() + " and has this many teeth " + teeth);
  }
  public String speak()
  {
     return "Purrrr";// takes precedence
  }
  public String move()
  {
     return "Hop";
  }

}
