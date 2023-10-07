package progbloque2.tarea13batalla;

public abstract class Material extends Recurso
{

  private int usos;

  public Material(int usos)
  {
    super();
    this.usos = usos;
  }

  public int getUsos()
  {
    return usos;
  }

  public void setUsos(int usos)
  {
    this.usos = usos;
  }
}
