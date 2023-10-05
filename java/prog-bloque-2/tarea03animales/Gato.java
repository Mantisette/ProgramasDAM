package progbloque2.tarea03animales;

public class Gato extends Mascota implements Productivo
{

  public Gato(String nombre)
  {
    super(nombre);
  }

  @Override
  public void producir()
  {
    System.out.println(this + ": cazando ratones");
  }

  @Override
  public void jugar()
  {
    System.out.println(this + ": ronroneando");
  }
}
