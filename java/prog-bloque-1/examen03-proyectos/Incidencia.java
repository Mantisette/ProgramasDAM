package progbloque1.examen3proyectos;

public class Incidencia
{

  private final int id;
  private final String descripcion;
  private final double coste;
  private boolean resuelta;

  public Incidencia(int id, String descripcion, double coste)
  {
    this.id = id;
    this.descripcion = descripcion;
    this.coste = coste;
    this.resuelta = false;
  }

  public boolean isResuelta()
  {
    return resuelta;
  }

  public void setResuelta(boolean resuelta)
  {
    this.resuelta = resuelta;
  }

  @Override
  public String toString()
  {
    return "Incidencia " + id + (resuelta ? " (resuelta)" : " (PENDIENTE)") +
      ": " + descripcion + "(" + String.format("%.2f", coste) + "€)";
  }
}
