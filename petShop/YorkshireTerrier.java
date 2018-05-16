/*
  Aviel Resnick
  Part of the AbstrPets Project
  2/20
*/

public class YorkshireTerrier extends Dog
{
  private String whereFrom;

  public YorkshireTerrier (String dogName, int weight)
  {
    super (dogName,weight);
  }

  public void setPlace(String location)
  {
    whereFrom = location;
  }

  public String speak()  // overwrites speak in Dog
  {
    // This is on purpose, my yorkie produces a sound which
    // resembels a meow.
    return  "Meow";
  }

  public String move()  // overwrites move in Dog
  {
    return  "Mighty Miniture Leaps";
  }

  public String cityOfOrigin()
  {
    return whereFrom;
  }

}
