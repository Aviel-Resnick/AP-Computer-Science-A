/*
  Aviel Resnick
  Part of the AbstrPets Project
  2/20
*/

public class Bulldog extends Dog  // concrete classes as well as
                                    // abstract classes can be extended by
                                    // another class
{
  private String whereFrom;

  public Bulldog (String dogName, int weight)
  {
    super (dogName,weight);
  }

  public void setPlace(String location)
  {
    whereFrom = location;
  }

  public String speak()  // overwrites speak in Dog
  {
    return "WOOF!!";
  }

  public String move()  // overwrites move in Dog
  {
    return  "Angry Jumps";
  }

  public String cityOfOrigin()
  {
    return whereFrom;
  }

}
