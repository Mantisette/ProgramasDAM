package progbloque4.tarea01factura;

import java.text.DecimalFormat;

public class Factura
{

  public static int contador=0;

  private final int id;
  private final double importe;
  private boolean pagada;

  public Factura(double importe)
  {
    this.importe = importe;
    id = contador++;
    pagada = false;
  }

  public void pagar()
  {
    pagada = true;
  }

  @Override
  public String toString()
  {
    DecimalFormat df = new DecimalFormat("#.00");
    String estado = pagada ? "pagada" : "pendiente";
    return "Factura" + "{" + "id=" + id + " -> importe=" + df.format(importe) +
      "€" + " -> " + estado + '}';
  }
}
