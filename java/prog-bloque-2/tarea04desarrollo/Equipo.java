package progbloque2.tarea04desarrollo;

import java.util.Arrays;

public class Equipo
{

  private final String nombre;
  private final Jefe jefeEquipo;
  private Programador[] programadoresEquipo;

  double costeAnual; // suma de todos los sueldos y bonus a lo largo del año

  public Equipo(String nombre, Jefe jefeEquipo, Programador[] programadoresEquipo)
  {
    this.nombre = nombre;
    this.jefeEquipo = jefeEquipo;
    if (programadoresEquipo != null)
      this.programadoresEquipo = Arrays.copyOf(programadoresEquipo, programadoresEquipo.length);

    calcularCosteAnual();
  }

  public Equipo(String nombre, Jefe jefeEquipo, int countProgramadoresEquipo)
  {
    this(nombre, jefeEquipo, new Programador[countProgramadoresEquipo]);
    if (this.programadoresEquipo == null)
      this.programadoresEquipo = new Programador[countProgramadoresEquipo];
    for(int i = 0; i < countProgramadoresEquipo; i++)
      this.programadoresEquipo[i] = new Programador();
    calcularCosteAnual();
  }

  public Equipo(String nombre, Programador[] programadoresEquipo)
  {
    this(nombre, new Jefe(), programadoresEquipo);
  }

  public Equipo(String nombre, int countProgramadoresEquipo)
  {
    this(nombre, new Jefe(), countProgramadoresEquipo);
  }

  @Override
  public String toString()
  {
    final StringBuilder sb = new StringBuilder();
    sb.append("Equipo ").append(nombre)
      .append("\n")
      .append(jefeEquipo)
      .append("\n");
    for (Programador programador : programadoresEquipo)
    {
      sb.append(programador.toString())
        .append("\n");
    }
    sb.append("Coste anual: ").append(costeAnual);

    return sb.toString();
  }

  public void calcularCosteAnual()
  {
    this.costeAnual = 0;
    // calculo de meses
    if (programadoresEquipo == null)
      return;

    for (Programador programador : programadoresEquipo)
    {
      if (programador == null)
        return;
      this.costeAnual += programador.getSueldo();
    }

    this.costeAnual += jefeEquipo.getSueldo();
    this.costeAnual *= 12;
    // bonuses
    this.costeAnual += jefeEquipo.getBonusAnual();
  }
}
