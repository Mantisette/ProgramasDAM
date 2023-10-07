package progbloque2.tarea12madmax;

public abstract class Gasolina
{

  private static double stock=0;

  public static void fabricar(int cantidad)
  {
    stock += cantidad;
    System.out.println("Fabricando " + cantidad + "l. de gasolina (Stock:" + stock + ")");
  }

  public static void usarCon(Motorizado motorizado,int km)
  {
    motorizado.conducir(km);
  }

  public static double getStock()
  {
    return stock;
  }

  public static void setStock(double stock)
  {
    Gasolina.stock = stock;
  }
}
