package progbloque2.tarea13batalla;

public final class EquipoMedico extends Humano implements Auxiliar
{

  private final int componentes;

  public EquipoMedico(int componentes)
  {
    super(VIDA_ESTANDAR);
    this.componentes = componentes;
  }

  @Override
  public String toString()
  {
    return getId() + "{vida:" + getVida() + "}";
  }

  @Override
  public void usarCon(Combatiente c, int cantidad)
  {
    if (this.getVida() <= 0)
    {
      System.out.println(this.getId() + ": no esta en condiciones de curar");
      return;
    }

    if (!(c instanceof Humano))
      System.out.println(this + ": solo puedo curar a humanos");
    else if (((Humano) c).getVida() <= 0)
      System.out.println(this + ": solo puedo curar a vivos");
    else
    {
      // reponer vida
      System.out.println(this.getId() + " curando a " + ((Humano) c).getId());

      int cambio = Math.min(this.getVida(), cantidad);
      ((Humano) c).setVida(((Humano) c).getVida() + cambio);
      this.setVida(this.getVida() - cambio);

      System.out.println(this);
      System.out.println(c);
    }
  }
}
