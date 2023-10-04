package progbloque1.examen2robots;

public class Robot
{

  public static final float PORCENTAJE_EFECTIVIDAD=0.5f;
  public static final int ENERGIA_DESCANSO=10;
  public static final int VALOR_MAXIMO=100;
  //Si se cambia el valor de ROBOTS_POR_EQUIPO, hay que revisar el metodo montaEquipo
  public static final int ROBOTS_POR_EQUIPO=3;

  private static int numRobots =0;//Debe reiniciarse cada ROBOTS_POR_EQUIPO incrementos

  private final String nombre;
  private int energia;
  private int integridad;

  //------------------------Constructores------------------------------
  public Robot(String equipo, int energia, int integridad)
  {
    if (numRobots >= ROBOTS_POR_EQUIPO)
      numRobots = 1;
    this.nombre = equipo + numRobots;

    //Me aseguro de que la energia este en los limites para que pueda golpear
    if (energia < 1)
      energia = 1;
    else if (energia>VALOR_MAXIMO) energia=VALOR_MAXIMO;
    this.energia = energia;
    //Me aseguro de que la integridad este en los limites para que este vivo
    if (integridad < 1)
      integridad=1;
    else if (integridad > VALOR_MAXIMO)
      integridad=VALOR_MAXIMO;
    this.integridad = integridad;
    numRobots++;

    saluda();
  }

  public Robot(String equipo,int valor)
  {
    this(equipo, valor,VALOR_MAXIMO - valor);
  }

  public Robot(String equipo)
  {
    this(equipo,(int) (Math.random() * VALOR_MAXIMO) + 1);
  }

  //-----------------------Acciones------------------------------
  public void saluda()
  {
    System.out.println(this + ": listo");
  }

  public void ataca(Robot objetivo, int intensidad)
  {
    if (integridad<=0)
    {
      System.out.println(this + ": estoy eliminado de la partida");
      return;
    }
    else if (energia<=0)
    {
      System.out.println(this + ": no tengo energia para pelear");
      return;
    }
    else if (intensidad<=0)
    {
      System.out.println(this + ": eso es una tonteria");
      return;
    }
    else if (objetivo.getIntegridad()<=0)
    {
      System.out.println(objetivo + " esta eliminado. No es etico atacarle");
      return;
    }

    System.out.println(this + ": atacando a " + objetivo);
    intensidad = Math.min(Math.min(energia, intensidad), VALOR_MAXIMO);
    modificaEnergia(-intensidad);
    objetivo.modificaIntegridad((int) (-intensidad * PORCENTAJE_EFECTIVIDAD));
  }

  public void descansa()
  {
    System.out.println(this + ": descansando");
    modificaEnergia(ENERGIA_DESCANSO);
  }

  public void ayuda(int cantidad, Robot receptor)
  {
    if (integridad<=0)
    {
      System.out.println(this + ": estoy eliminado de la partida");
      return;
    }
    else if (this == receptor)
    {
      System.out.println(this + ": no me puedo ayudar a mi mismo");
      return;
    }
    else if (receptor.getIntegridad() <= 0)
    {
      //Solo puedes ayudar si tiene algo de integridad (si esta vivo)
      System.out.println(this + ": ya es tarde para el. " + receptor + " es irrecuperable");
      return;
    }
    else if (cantidad <= 0)
    {
      System.out.println(this + ": eso es una tonteria");
      return;
    }
    if (cantidad > integridad)
      cantidad = integridad;
    System.out.println(this + ": trasvasando " + cantidad + " uds. de integridad a " + receptor);
    modificaIntegridad(-cantidad);
    receptor.modificaIntegridad(cantidad);
  }

  //------------------Genericos-------------------------------------
  public static Robot[] montaEquipo(String nombre)
  {
    Robot[] equipo=new Robot[ROBOTS_POR_EQUIPO];
    equipo[0]=new Robot(nombre, 100, 100);
    equipo[1]=new Robot(nombre, 60);
    equipo[2]=new Robot(nombre);
    return equipo;
  }

  @Override
  public String toString()
  {
    if (integridad<=0)
      return nombre+"(desactivado)";
    else
      return nombre + "(E:" + energia + ", I:" + integridad + ")";
  }

  //-----------------Getters y setters-----------------------------
  public void modificaEnergia(int cantidad)
  {
    energia+=cantidad;
    if (energia < 0)
      energia=0;
    else if (energia > VALOR_MAXIMO)
      energia=VALOR_MAXIMO;
    if (energia == 0)
      System.out.println(this + ": agotado");
  }

  public int getIntegridad()
  {
    return integridad;
  }

  public void modificaIntegridad(int cantidad)
  {
    integridad+=cantidad;
    if (integridad < 0)
      integridad=0;
    else if (integridad > VALOR_MAXIMO)
      integridad=VALOR_MAXIMO;
    if (integridad == 0)
      System.out.println(this + ": DESACTIVANDO...");
  }
}
