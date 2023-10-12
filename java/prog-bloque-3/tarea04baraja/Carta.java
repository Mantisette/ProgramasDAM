package progbloque3.tarea04baraja;

import java.util.Objects;

public class Carta implements Comparable<Carta>
{

  final Palo palo;
  final Valor valor;

  public Carta(Palo palo, Valor valor)
  {
    this.palo = palo;
    this.valor = valor;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Carta carta = (Carta) o;
    return palo == carta.palo && valor == carta.valor;
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(palo, valor);
  }

  @Override
  public int compareTo(Carta target)
  {
    if (this.palo.compareTo(target.palo) < 0)
      return -1;
    else if (this.palo.compareTo(target.palo) > 0)
      return 1;
    else
      return (this.valor.compareTo(target.valor));
  }

  @Override
  public String toString()
  {
    return valor.valor + " de " + palo.palo;
  }
}
