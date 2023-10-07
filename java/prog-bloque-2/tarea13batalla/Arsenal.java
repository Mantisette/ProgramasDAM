package progbloque2.tarea13batalla;

public final class Arsenal extends Material implements Auxiliar
{

  public Arsenal(int usos)
  {
    super(usos);
  }

  @Override
  public String toString()
  {
    return getId() + "{stock:" + getUsos() + "}";
  }

  @Override
  public void usarCon(Combatiente c, int cantidad)
  {
    if (!(c instanceof Material))
      System.out.println(this + " solo puede recargar materiales");
    else if (this.getUsos() <= 0)
      System.out.println(this + " no puede recargar por falta de stock");
    else
    {
      // reponer vida
      System.out.println(this.getId() + " recargando " + c.obtenerIdentificador());

      int cambio = Math.min(this.getUsos(), cantidad);
      ((Material) c).setUsos(((Material) c).getUsos() + cambio);
      this.setUsos(this.getUsos() - cambio);

      System.out.println(this);
      System.out.println(c);
    }
  }
}
