package progbloque1.examen3proyectos;

public class Presupuesto
{

  //  Una vez creado, no admite modificaciones, salvo la expuesta en el siguiente parrafo.
  private double importeNominas;
  private final double importeLicencia;
  private double importeHorasExtra;
  private double importeIncidencias;
  private double importeTotal;

  public Presupuesto(double importeNominas, double importeLicencia, double importeHorasExtra, double importeIncidencias)
  {
    // Control importes estrictamente positivos
    if (importeNominas <= 0)
      importeNominas = 1;
    if (importeLicencia <= 0)
      importeLicencia = 1;
    if (importeHorasExtra <= 0)
      importeHorasExtra = 1;
    if (importeIncidencias <= 0)
      importeIncidencias = 1;

    this.importeNominas = importeNominas;
    this.importeLicencia = importeLicencia;
    this.importeHorasExtra = importeHorasExtra;
    this.importeIncidencias = importeIncidencias;
    refrescarImporteTotal();
  }

  void prolongarPresupuesto(double proporcion)
  {
    this.importeNominas *= proporcion;
    this.importeHorasExtra *= proporcion;
    this.importeIncidencias *= proporcion;
  }

  @Override
  public String toString()
  {
    return "Presupuesto: " + "\n\t\tNominas: " +
      String.format("%.2f€", importeNominas) + "\n\t\tLicencia: " +
      String.format("%.2f€", importeLicencia) + "\n\t\tHoras Extra: " +
      String.format("%.2f€", importeHorasExtra) + "\n\t\tImprevistos: " +
      String.format("%.2f€", importeIncidencias) + "\n\t\tTotal: " +
      String.format("%.2f€", importeTotal);
  }

  public double getImporteNominas()
  {
    return importeNominas;
  }

  public void setImporteNominas(double importeNominas)
  {
    this.importeNominas = importeNominas;
    refrescarImporteTotal();
  }

  public double getImporteLicencia()
  {
    return importeLicencia;
  }

  public double getImporteHorasExtra()
  {
    return importeHorasExtra;
  }

  public void setImporteHorasExtra(double importeHorasExtra)
  {
    this.importeHorasExtra = importeHorasExtra;
    refrescarImporteTotal();
  }

  public double getImporteIncidencias()
  {
    return importeIncidencias;
  }

  public void setImporteIncidencias(double importeIncidencias)
  {
    this.importeIncidencias = importeIncidencias;
    refrescarImporteTotal();
  }

  //"setter personalizado" para refrescar importeTotal cuando se modifican los importes
  public void refrescarImporteTotal()
  {
    this.importeTotal = this.importeNominas + this.importeLicencia
      + this.importeHorasExtra + this.importeIncidencias;
  }
}
