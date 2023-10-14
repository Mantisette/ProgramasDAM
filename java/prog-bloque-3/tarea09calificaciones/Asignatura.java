package progbloque3.tarea09calificaciones;

public enum Asignatura
{

  PROG("PROG", "Programacion"),
  BBDD("BBDD", "Bases de Datos"),
  SIST("SIST", "Sistemas Informaticos"),
  LENG("LENG", "Lenguajes"),
  FOL_("FOL_", "FOL"),
  ENTD("ENTD", "Entornos de Desarrollo");

  final String id;
  final String nombre;

  Asignatura(String id, String nombre)
  {
    this.id = id;
    this.nombre = nombre;
  }
}
