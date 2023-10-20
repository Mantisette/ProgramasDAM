package progbloque4.tarea08facturasbinario;

import java.io.Serializable;

public class Factura implements Serializable {
  String referencia;
  double importe;
  boolean abonada;

  public Factura(String referencia, double importe, boolean abonada) {
    this.referencia = referencia;
    this.importe = importe;
    this.abonada = abonada;
  }

  @Override
  public String toString() {
    String indicador=(abonada)?"(A)":"(P)";
    return referencia + ": " + importe + indicador;
  }
}
