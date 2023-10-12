package progbloque3.tarea06conjuntoletras;

import java.util.Objects;

public class Letra
{

  public final static String abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  static int contador = 0;

  private final int id;
  private final String nombre;

  public Letra()
  {
    contador++;
    this.id = contador;
    int posicion = (int)(Math.random() * abecedario.length());
    this.nombre = abecedario.substring(posicion, posicion + 1);
  }

  @Override
  public String toString()
  {
    return id + "-" + nombre ;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Letra letra = (Letra) o;
    return Objects.equals(nombre, letra.nombre);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(nombre);
  }
}
