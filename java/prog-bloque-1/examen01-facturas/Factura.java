package progbloque1.examen1facturas;

public class Factura
{

  public static final int TOPE = 1000;
  private static int numFacturasCreadas = 0;
  private static int numFacturasPendientes; //[creadas - abonadas = pendientes]
  private static int numFacturasAbonadas;
  private static double importeFacturasPendientes = 0;
  private static double importeFacturasAbonadas = 0;

  private final int id;
  private final String cliente;
  private double importeNeto;
  private boolean abonada;

  public Factura(String cliente, double importeNeto)
  {
    this.id = ++numFacturasCreadas;
    this.cliente = cliente;
    this.importeNeto = importeNeto;
    this.abonada = false;

    numFacturasPendientes++;
    importeFacturasPendientes += this.importeNeto;
  }

  @Override
  public String toString()
  {
    return "(" + id + ") " + cliente + " --> " +
      String.format("%.2f", importeNeto) + " € " +
      (abonada ? "(Abonada)" : "(Pendiente de pago)");
  }

  public static int getCountFacturasCreadas()
  {
    return numFacturasCreadas;
  }

  public static int getCountFacturasPendientes()
  {
    return numFacturasPendientes;
  }

  public static int getCountFacturasAbonadas()
  {
    return numFacturasAbonadas;
  }

  public static double getImporteFacturasPendientes()
  {
    return importeFacturasPendientes;
  }

  public static double getImporteFacturasAbonadas()
  {
    return importeFacturasAbonadas;
  }

  public String getCliente()
  {
    return cliente;
  }

  public void setImporteNeto(double importeNeto)
  {
    importeFacturasPendientes += importeNeto - this.importeNeto;
    this.importeNeto = importeNeto;
  }

  public boolean isAbonada()
  {
    return abonada;
  }

  public void setAbonada(boolean abonada)
  {
    this.abonada = abonada;
    numFacturasAbonadas++;
    numFacturasPendientes--;
    importeFacturasAbonadas += this.importeNeto;
    importeFacturasPendientes -= this.importeNeto;
  }
}
