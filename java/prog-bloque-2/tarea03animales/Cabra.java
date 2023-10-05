package progbloque2.tarea03animales;

public class Cabra extends Ganado implements Amigable
{

  public static final String PRODUCTO_DEFECTO = "carne";

  public Cabra()
  {
    super(PRODUCTO_DEFECTO);
  }

  @Override
  public void producir()
  {
    System.out.println(this + ": produciendo " + PRODUCTO_DEFECTO);
  }

  @Override
  public void jugar()
  {
    System.out.println(this + ": bieeeeeeeeeen");
  }
}
