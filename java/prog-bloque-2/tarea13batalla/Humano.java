package progbloque2.tarea13batalla;

public abstract class Humano extends Recurso
{

  static final int VIDA_ESTANDAR=100;
  private int vida;

  public Humano(int vida)
  {
    super();
    this.vida=vida;
  }

  public int getVida()
  {
    return vida;
  }

  public void setVida(int vida)
  {
    this.vida = vida;
  }
}
