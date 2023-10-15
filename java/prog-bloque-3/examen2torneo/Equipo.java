package progbloque3.examen2torneo;

import java.util.ArrayList;
import java.util.Objects;

public class Equipo
{

  private final String nombre;
  private final String pais;
  ArrayList<String> jugadores = new ArrayList<>();

  public Equipo(String nombre,String pais)
  {
    this.nombre = nombre;
    this.pais=pais;
  }

  public void inscribeJugador(String jugador)
  {
    jugadores.add(jugador);
  }

  @Override
  public String toString()
  {
    return "\t"+nombre + jugadores;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Equipo equipo = (Equipo) o;

    return nombre.equals(equipo.nombre) && pais.equals(equipo.pais);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(nombre, pais);
  }
}
