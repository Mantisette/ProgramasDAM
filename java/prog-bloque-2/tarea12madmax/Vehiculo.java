package progbloque2.tarea12madmax;

public abstract class Vehiculo
{

  private static int contador = 0;
  private static int kmTotal = 0;
  private final int id;

  public Vehiculo()
  {
    id = ++contador;
  }

  @Override
  public String toString()
  {
    return getClass().getSimpleName()+id;
  }

  public static int getKmTotal()
  {
    return kmTotal;
  }

  public static void setKmTotal(int kmTotal)
  {
    Vehiculo.kmTotal = kmTotal;
  }
}
