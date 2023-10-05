package progbloque2.tarea03animales;

public class Perro extends Mascota implements Productivo
{

  public Perro(String nombre)
  {
    super(nombre);
  }

  @Override
  public void producir()
  {
    System.out.println(this + ": guardando la casa");
  }

  @Override
  public void jugar()
  {
    System.out.println(this + ": agitando la cola");
  }
}
