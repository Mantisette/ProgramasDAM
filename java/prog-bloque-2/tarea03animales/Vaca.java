package progbloque2.tarea03animales;

public class Vaca extends Ganado
{

  public static final String PRODUCTO_DEFECTO = "leche";

  public Vaca()
  {
    super(PRODUCTO_DEFECTO);
  }

  @Override
  public void producir()
  {
    System.out.println(this + ": produciendo " + PRODUCTO_DEFECTO);
  }
}
