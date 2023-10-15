package progbloque3.examen1finalfight;

public abstract class Villano extends Personaje implements Comparable<Villano>
{

  //Constantes
  public static final int TOPE_ENEMIGOS = 4; //para ajustar la dificultad del juego
  private static final int TOPE_BATALLA = 2; //para ajustar la dificultad del juego
  private static final double PROB_EXITO_OCULTACION = 0.25; //para ajustar la dificultad del juego
  public static final int VIDA_INICIAL = 100; //para ajustar la dificultad del juego

  //Propiedades de clase
  private static int contadorTotal = 0; //Siempre indicará el total de enemigos generados
  private static int contadorVivos = 0;

  //Propiedades de instancia
  private boolean oculto;
  private final int id;
  private final int recompensa;

  public Villano(String inicial,int recompensa)
  {
    super(Utilidades.generaNombreAleatorio(inicial), VIDA_INICIAL);
    oculto = false;
    id = contadorTotal;
    this.recompensa = recompensa;
    contadorTotal++;
    contadorVivos++;
    decir("Aquí estoy");
  }


  //------------------------------- ACCIONES ---------------------------------
  public boolean ocultar()
  {
    //Devuelve true si se ha ocultado con éxito; false en caso contrario
    if (Math.random() < PROB_EXITO_OCULTACION)
    {
      oculto = true;
      decir("¡Cu-cu, no me ves!");
    }
    else
      oculto = false;

    return oculto;
  }

  public Villano pedirAyuda()
  {
    if (contadorVivos >= TOPE_BATALLA)
    {
      decir("¡Nosotros " + contadorVivos + " deberíamos bastarnos!");
      return null; //no se llama a nuevas fuerzas
    }
    else
    {
      decir("¡AYUDA!");
      return generaVillanoaleatorio();
    }

  }

  //---------------------------- COMPARACIÓN ---------------------------------

  @Override
  public int compareTo(Villano target)
  {
    if (getEnergia() < target.getEnergia())
      //Los que tienen menos energía van antes
      return -1;
    else if (getEnergia() > target.getEnergia())
      return 1;
    else
      //Si tienen igual energía, me rijo por el tiempo en el campo de batalla (id)
      return Integer.compare(id, target.id);
  }


  //---------------------- GETTERS y SETTERS ---------------------------------

  public static int getContadorTotal()
  {
    return contadorTotal;
  }

  public static void setContadorTotal(int contadorTotal)
  {
    Villano.contadorTotal = contadorTotal;
  }

  public static int getContadorVivos()
  {
    return contadorVivos;
  }

  public static void setContadorVivos(int contadorVivos)
  {
    Villano.contadorVivos = contadorVivos;
  }

  public static void reduceContadorVivos(int cantidad)
  {
    Villano.contadorVivos -= cantidad;
  }

  public int getId()
  {
    return id;
  }

  public boolean isOculto()
  {
    return oculto;
  }

  public void setOculto(boolean oculto)
  {
    this.oculto  =  oculto;
  }

  public int getRecompensa()
  {
    return recompensa;
  }

  //---------------------- MÉTODOS DE CLASE ----------------------------------
  static Villano generaVillanoaleatorio()
  {
    //Si se ha alcanzado el tope de villanos, ya no se añaden más
    //En caso contrario, se crea un nuevo villano
    if (contadorTotal >= TOPE_ENEMIGOS)
      return null;
    else
      return (Math.random()<Probabilidad.GUERRERO.valor)?new Guerrero():new Nigromante();
  }
}
