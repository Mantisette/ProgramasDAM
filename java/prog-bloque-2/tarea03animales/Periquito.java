package progbloque2.tarea03animales;

public final class Periquito extends Mascota
{

  public Periquito(String nombre)
  {
    super(nombre);
  }

  public void jugar()
  {
    System.out.println(this + ": picoteando");
  }
}
