package progbloque2.examen02seres.entidad;

import progbloque2.examen02seres.posicion.*;

public abstract class Biologico extends Ser
{

  public static final int VIDA_MAX=100;
  private int vida;

  public Biologico(Punto punto, boolean movil)
  {
    super(punto,movil);
    this.vida = VIDA_MAX;
  }

  public void alimentar()
  {
    System.out.print(id + ": ");
  }

  public final void sufrir(int cantidad)
  {
    this.vida = Math.max(0, this.vida - cantidad);
  }

  @Override
  public String toString()
  {
    return super.toString() + "...vida " + vida + "%";
  }
}
