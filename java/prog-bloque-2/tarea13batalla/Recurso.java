package progbloque2.tarea13batalla;

public abstract class Recurso implements Comparable
{

  private static int contador=0;
  private final String id;

  public Recurso()
  {
    contador++;
    id = this.getClass().getSimpleName() + "-" + contador; // por probar
  }

  public String getId()
  {
    return id;
  }

  @Override
  public int compareTo(Object o)
  {
    if (!(o instanceof Recurso))
      return -1;
    else
      return (this.id.compareToIgnoreCase(((Recurso) o).id));
  }
}
