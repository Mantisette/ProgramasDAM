package progbloque2.examen01finalfight;

public abstract class Villano extends Personaje implements Comparable
{

  //Constantes
  public static final int TOPE_ENEMIGOS = 4000; //para ajustar la dif icultad del juego
  private static final int TOPE_BATALLA = 10; //para ajustar la dif icultad del juego
  private static final double PROB_EXITO_OCULTACION = 0.25; //para ajustar la dif icultad del juego
  public static final int VIDA_INICIAL = 50; //para ajustar la dif icultad del juego
  public static final String VOCALES = "aeiou";
  public static final String CONSONANTES = "bcdfghjklmnpqrstvwxyz";

  //Propiedades de clase
  private static int contadorTotal = 0; //Siempre indicara el total de enemigos generados
  private static int contadorVivos = 0;

  //Propiedades de instancia
  private boolean oculto;
  private final int id;
  private final int recompensa;

  public Villano(String inicial,int recompensa)
  {
    super(generaNombreAleatorio(inicial), VIDA_INICIAL);
    oculto = false;
    id = contadorTotal;
    this.recompensa = recompensa;
    contadorTotal++;
    contadorVivos++;
    decir("Aqui estoy");
  }


  //------------------------------- ACCIONES ---------------------------------
  public boolean ocultar()
  {
    //Devuelve true si se ha ocultado con exito; false en caso contrario
    if (Math.random()<0.25)
    {
      oculto = true;
      decir("¡Cu-cu, no me ves!");
      return true;
    }
    else
    {
      oculto = false;
      return false;
    }
  }

  public Villano pedirAyuda()
  {
    if (contadorVivos >= TOPE_BATALLA)
    {
      decir("¡Nosotros " + contadorVivos + " deberiamos bastarnos!");
      return null; //no se llama a nuevas fuerzas
    }
    else
    {
      decir("¡AYUDA!");
      return generaVillanoaleatorio();
    }

  }

  //----------------------- PRESENTACIoN ---------------------------------
  //Cada uno el suyo



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
    this.oculto = oculto;
  }

  public int getRecompensa()
  {
    return recompensa;
  }

  //---------------------- MeTODOS DE CLASE ----------------------------------
  static Villano generaVillanoaleatorio()
  {
    //Si se ha alcanzado el tope de villanos, ya no se añaden mas
    //En caso contrario, se crea un nuevo villano y se devuelve
    if (contadorTotal >= TOPE_ENEMIGOS)
      return null;
    else
      return (Math.random() < Probabilidad.GUERRERO.valor) ? new Guerrero() : new Nigromante();
  }

  private static String generaNombreAleatorio(String inicial)
  {
    StringBuilder nombre = new StringBuilder(inicial);
    nombre.append(vocalAleatoria());
    nombre.append(consonanteAleatoria());
    if (Math.random()<0.5)
    {
      //por añadir un poco de variedad a la estructura
      nombre.append(vocalAleatoria());
      nombre.append(consonanteAleatoria());
    }
    else
    {
      nombre.append(consonanteAleatoria());
      nombre.append(vocalAleatoria());
    }

    return nombre.toString();
  }

  private static String vocalAleatoria()
  {
    int pos = (int) (Math.random()*VOCALES.length());
    return VOCALES.substring(pos,pos+1);
  }

  private static String consonanteAleatoria()
  {
    int pos = (int) (Math.random()*CONSONANTES.length());
    return CONSONANTES.substring(pos,pos+1);
  }

  //-------------------------  COMPARACIoN ---------------------------------

  @Override
  public int compareTo(Object o)
  {
    Villano otro = (Villano)o;
    if (this.getEnergia() > otro.getEnergia())
      return 1;
    else if (this.getEnergia() < otro.getEnergia())
      return -1;
    else
      return (this.id - otro.id);
  }
}
