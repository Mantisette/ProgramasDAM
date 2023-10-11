package progbloque3.tarea01delincuentes;

public class Banda<T>
{

  public static final int TOPE = 100;
  public static final String TITULO = "Listado de bandas de delincuentes";
  public static final Banda[] bandas = new Banda[TOPE];
  private static int contador = 0;

  private final String ubicacion;
  private final int miembros;
  private final T lider;
  private final String nombre;

  private Banda(String nombre, String ubicacion, int miembros, T lider)
  {
    this.nombre = nombre;
    this.ubicacion  =  ubicacion;
    this.miembros  =  miembros;
    this.lider = lider;

    bandas[contador]  =  this;
    contador++;
  }

  public static <T> void nueva(String nombre, String ubicacion, int miembros, T lider)
  {
    if (contador >= TOPE)
    {
      System.out.println("Ya no caben mas chorizos!!");
      return;
    }

    new Banda<>(nombre, ubicacion, miembros, lider);
  }

  public String getUbicacion()
  {
    return ubicacion;
  }

  public int getMiembros()
  {
    return miembros;
  }

  public T getLider()
  {
    return lider;
  }

  public String getTipo()
  {
    return lider.getClass().getSimpleName();
  }

  @Override
  public String toString()
  {
    return "\t" + nombre + "(" + getTipo() + ")" + "-->"  +  "ubicacion = "  +  ubicacion  +  ", miembros = "  +  miembros  +  ", lider = "  +  lider;
  }

  public static String recuperarListado()
  {
    StringBuilder sb = new StringBuilder(TITULO + "(" + contador + "):\n");
    for (Banda b : bandas)
    {
      if(b == null)
        break;
      sb.append(b).append("\n");
    }
    return sb.toString();
  }
}
