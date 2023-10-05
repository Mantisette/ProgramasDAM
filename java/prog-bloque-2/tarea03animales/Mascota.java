package progbloque2.tarea03animales;

public abstract class Mascota extends Animal implements Amigable
{

  public static int countMascota = 0;

  String nombre;

  public Mascota(String nombre)
  {
    super(++countMascota);
    this.nombre = nombre;
  }

  @Override
  public String toString()
  {
    return super.toString() + "(" + nombre + ")";
  }
}
