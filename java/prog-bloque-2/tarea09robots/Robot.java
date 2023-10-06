package progbloque2.tarea09robots;

public abstract class Robot
{

  public static int countRobots = 0;

  String nombre;
  int index;
  String id;

  public Robot(String nombre)
  {
    this.nombre = nombre;
    this.index = ++countRobots;
    this.id = nombre + '-' + index;
  }

  public void encender()
  {
    System.out.println(this.id + ": ...ON...");
  }

  public void apagar()
  {
    System.out.println(this.id + ": ...OFF..");
  }

  @Override
  public String toString()
  {
    return this.id;
  }
}
