package progbloque2.tarea09robots;

public class Humano implements Vida
{

  String nombre;

  public Humano(String nombre)
  {
    this.nombre = nombre;
  }

  @Override
  public String toString()
  {
    return this.nombre;
  }

  @Override
  public void identificarNombreSelf()
  {
    System.out.println(this.nombre);
  }

  @Override
  public void saludar()
  {
    System.out.println(this + ": ¡Hola!");
  }

  @Override
  public void llorar()
  {
    System.out.println(this + ": ¡Snif, buaaaaaaah!");
  }
}
