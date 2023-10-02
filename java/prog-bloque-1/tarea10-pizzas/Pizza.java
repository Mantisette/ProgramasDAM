package progbloque1.tarea10pizzas;

public class Pizza
{

  private static int numPedidas;
  private static int numServidas;

  private final String tipo;
  private final String tamano;
  private String estado;

  public Pizza(String tipo, String tamano)
  {
    this.tipo = tipo;
    this.tamano = tamano;
    this.estado = "pedida";
    numPedidas++;
  }

  public void sirve()
  {
    if (this.estado.equals("servida"))
    {
      System.out.println("Esa pizza ya esta servida");
      return;
    }
    this.estado = "servida";
    numServidas++;
  }

  @Override
  public String toString()
  {
    return "pizza " + tipo + " " + tamano + ", " + estado;
  }

  public static int getNumPedidas()
  {
    return numPedidas;
  }

  public static int getNumServidas()
  {
    return numServidas;
  }
}
