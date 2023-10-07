package progbloque2.tarea13batalla;

public final class Escuadron extends Humano implements Combatiente
{

  private static final int CAPACIDAD_ATAQUE_INDIVIDUAL=10;
  private final int componentes;
  private final int ataque;

  public Escuadron(int componentes)
  {
    super(componentes * VIDA_ESTANDAR);
    this.componentes = componentes;
    this.ataque = componentes * CAPACIDAD_ATAQUE_INDIVIDUAL;
  }

  @Override
  public String toString()
  {
    return getId() + "{ataque:" + ataque + ", vida:" + getVida() + "}";
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
      return true;
    else
    {
      System.out.println(this.obtenerIdentificador() + ": no esta en condiciones de atacar");
      return false;
    }
  }

  @Override
  public void encajarAtaque(int fuerza)
  {
    if (this.getVida() <= 0)
      System.out.println(this.obtenerIdentificador() + ": ya estaba muerto");
    else
    {
      this.setVida(Math.max(0, getVida() - fuerza));

      if (this.getVida() <= 0)
        System.out.println(this.obtenerIdentificador() + ": MASACRADO!!");
    }
  }
}
