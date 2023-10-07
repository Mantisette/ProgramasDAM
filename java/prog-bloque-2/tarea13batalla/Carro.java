package progbloque2.tarea13batalla;

public final class Carro extends Material implements Combatiente
{

  private final int ataque;
  private int resistencia;
  private final VariedadCarro variedad;

  public Carro(VariedadCarro variedad)
  {
    super(variedad.usosIniciales);
    this.variedad = variedad;
    this.ataque = variedad.ataque;
    this.resistencia = variedad.resistenciaInicial;
  }

  @Override
  public String toString()
  {
    return getId() + "{variedad=" + variedad + ", ataque=" + ataque + ", resistencia=" + resistencia + ", usos:" + getUsos() + "}";
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
    this.setUsos(this.getUsos() - 1);
    return (resistencia > 0 && getUsos() > 0);
  }

  @Override
  public void encajarAtaque(int fuerza)
  {
    if (this.resistencia <= 0)
      System.out.println(this.obtenerIdentificador() + ": ya estaba muerto");
    else
    {
      this.resistencia = Math.max(0, resistencia - fuerza);
      if (this.resistencia <= 0)
        System.out.println(this.obtenerIdentificador() + ": MASACRADO!!");
    }
  }
}
