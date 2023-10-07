package progbloque2.tarea13batalla;

public final class Francotirador extends Humano implements Combatiente
{

  private static final double CAMUFLAJE_INICIAL=1;
  private static final double DETERIORO_CAMUFLAJE=0.1;
  private static final int CAPACIDAD_ATAQUE=100;

  private double camuflaje;
  private final int ataque;

  public Francotirador()
  {
    super(VIDA_ESTANDAR);
    this.camuflaje = CAMUFLAJE_INICIAL;
    this.ataque = CAPACIDAD_ATAQUE;
  }

  @Override
  public String toString()
  {
    return getId() + "{ataque:" + ataque + ", vida:" + getVida() + ", camuflaje:" + String.format("%.2f",camuflaje) + "}";
  }

  @Override
  public String obtenerIdentificador()
  {
    return getId();
  }

  @Override
  public int obtenerFuerzaAtaque()
  {
    return ataque;
  }

  @Override
  public boolean esPosibleAtacar()
  {
    if (getVida() > 0)
    {
      camuflaje -= DETERIORO_CAMUFLAJE;
      return true;
    }
    else
      return false;
  }

  @Override
  public void encajarAtaque(int fuerza)
  {
    if (this.getVida() <= 0)
      System.out.println(this.obtenerIdentificador() + ": ya estaba muerto");
    else
    {
      double tiradaEsquive;
      tiradaEsquive = Math.random();
      if (tiradaEsquive > this.camuflaje)
      {
        this.setVida(Math.max(0, this.getVida() - fuerza));

        if (this.getVida() <= 0)
          System.out.println(this.obtenerIdentificador() + ": MASACRADO!!");
      } else
        System.out.println(this + ": Como me vas a dar si no me ves!");
    }
  }
}
