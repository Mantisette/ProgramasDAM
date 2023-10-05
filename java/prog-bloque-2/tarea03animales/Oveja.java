package progbloque2.tarea03animales;

public class Oveja extends Ganado
{

  public static final String PRODUCTO_DEFECTO = "lana";

  public Oveja()
  {
    super(PRODUCTO_DEFECTO);
  }

  @Override
  public void producir()
  {
    System.out.println(this + ": produciendo " + PRODUCTO_DEFECTO);
  }
}
