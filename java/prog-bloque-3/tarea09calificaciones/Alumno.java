package progbloque3.tarea09calificaciones;

import java.util.TreeMap;
import java.util.Objects;

public class Alumno implements Comparable<Alumno>
{

  private static int countAlumnos = 0;

  private final int id;
  private final String nombre;
  private final TreeMap<Asignatura, Integer> calificaciones;

  public Alumno(String nombre)
  {
    this.id = ++countAlumnos;
    this.nombre = nombre;
    this.calificaciones = new TreeMap<>();
  }

  public void ponerNota(Asignatura asig, int nota)
  {
    calificaciones.put(asig, nota);
  }

  @Override
  public String toString()
  {
    final StringBuilder sb = new StringBuilder();

    sb.append(nombre).append('(').append(id).append(") -> ");
    for (Asignatura asignatura : calificaciones.keySet())
    {
      sb.append(asignatura.nombre).append(": ")
        .append(calificaciones.get(asignatura)).append(" ");
    }

    return sb.toString();
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Alumno alumno = (Alumno) o;
    return id == alumno.id;
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(id);
  }

  @Override
  public int compareTo(Alumno o)
  {
    return this.nombre.compareToIgnoreCase(o.nombre);
  }
}
