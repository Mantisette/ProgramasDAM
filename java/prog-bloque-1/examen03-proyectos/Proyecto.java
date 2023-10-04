package progbloque1.examen3proyectos;

public class Proyecto
{

  private static final int MAX_INCIDENCIAS=100;
  //Para utilizar como valores por defecto para un proyecto
  private static final Presupuesto PRESUPUESTO_DEFECTO=new Presupuesto(50000,2000,10000,10000);
  private static final int DIAS_DEFECTO=30;

  private static int contadorIncidencias = 0;
  private double costeIncidencias = 0;

  private final String nombre;
  private final Presupuesto presupuesto;
  private int dias;
  private final Incidencia[] incidenciasProyecto = new Incidencia[MAX_INCIDENCIAS];

  // constructores
  public Proyecto(String nombre, Presupuesto presupuesto, int dias)
  {
    this.nombre = nombre;
    this.presupuesto = new Presupuesto(
      presupuesto.getImporteNominas(),
      presupuesto.getImporteLicencia(),
      presupuesto.getImporteHorasExtra(),
      presupuesto.getImporteIncidencias()
    ); // DONE: controlar que el presupuesto sea independiente para cada proyecto
    this.dias = Math.max(dias, 1);
  }

  public Proyecto(String nombre)
  {
    this(nombre, PRESUPUESTO_DEFECTO, DIAS_DEFECTO);
  }

  // toString()
  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder(nombre.toUpperCase())
      .append("\n\tDuracion: ").append(dias).append(" dias")
      .append("\n\t").append(presupuesto)
      .append("\n\tIncidencias(").append(String.format("%.2f",costeIncidencias))
      .append("€)");
    for(int i=0;i<contadorIncidencias;i++){
      sb.append("\n\t\t").append(incidenciasProyecto[i]);
    }

    return sb.toString();
  }

  // getters & setters
  public static int getContadorIncidencias()
  {
    return contadorIncidencias;
  }

  public Incidencia[] getIncidenciasProyecto()
  {
    // devolver copia del array
    return incidenciasProyecto.clone();
  }

  // metodos
  public void prolongar(int diasSumando)
  {
    if (diasSumando <= 0)
    {
      System.out.println("Solo se aceptan prolongaciones estrictamente positivas");
      return;
    }

    int diasFinales = this.dias + diasSumando;
    double proporcion = (double)diasFinales / (double)this.dias;

    presupuesto.prolongarPresupuesto(proporcion);

    // el presupuesto solo se cambia en este proyecto, gracias al control del constructor
    this.dias = diasFinales;
  }

  public void registraIncidencia(String descripcion, double coste)
  {
    Incidencia incidenciaActual;

    // controlar que las incidencias no se pasen del presupuesto
    if (costeIncidencias+coste >= presupuesto.getImporteIncidencias())
    {
      System.out.println("ERROR: No se puede registrar la incidencia por falta de presupuesto");
      return;
    }

    // nueva incidencia
    incidenciaActual = new Incidencia(contadorIncidencias + 1, descripcion, coste);
    incidenciasProyecto[contadorIncidencias] = incidenciaActual;
    contadorIncidencias++;
    costeIncidencias += coste;

    // output
    System.out.println("Registrando incidencia ... " + incidenciaActual);
  }

  public void resuelveIncidencia(int idIncidencia)
  {
    Incidencia incidenciaActual = incidenciasProyecto[idIncidencia-1];

    // controlar que la incidencia sea valida (not null y no resuelta)
    if (incidenciaActual == null)
    {
      System.out.println("ERROR: esa incidencia no existe");
      return;
    }
    if (incidenciaActual.isResuelta())
    {
      System.out.printf("ERROR: La incidencia %d ya estaba resuelta!!\n", idIncidencia);
      return;
    }

    // desde aqui, incidencia ok
    incidenciasProyecto[idIncidencia-1].setResuelta(true);
    System.out.println("Resolviendo incidencia ... " + incidenciaActual);
  }
}
