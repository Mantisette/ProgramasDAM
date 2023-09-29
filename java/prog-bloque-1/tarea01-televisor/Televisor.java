package progbloque1.tarea01televisor;

public class Televisor
{

  public static final int ANIO_DEFECTO = 2000;
  public static final int MIN_ANIO = 1950;
  public static final int MAX_ANIO = 2200;
  public static final int MIN_VOL = 0;
  public static final int MAX_VOL = 100;
  public static final int MIN_CANAL = 0;
  public static final int MAX_CANAL = 0;

  private final String marca;
  private final String modelo;
  private final int anio;
  private final boolean panoramica;
  private final boolean stereo;
  private boolean encendida;
  private int volumen;
  private int canal;

  public Televisor(String marca, String modelo, int anio, boolean panoramica, boolean stereo)
  {
    this.marca = marca;
    this.modelo = modelo;

    if (anio < MIN_ANIO || anio > MAX_ANIO)
    {
      System.out.println("El año seleccionado no es valido. Año por defecto: 2000");
      this.anio = ANIO_DEFECTO;
    }
    else
      this.anio = anio;

    this.panoramica = panoramica;
    this.stereo = stereo;
    this.encendida = false;
    this.volumen = 0;
    this.canal = 0;
  }

  public void encender()
  {
    if (!this.encendida)
    {
      this.encendida = true;
      System.out.println("Encendiendo televisor.");
    }
  }

  public void apagar()
  {
    if (this.encendida)
    {
      this.encendida = false;
      System.out.println("Apagando televisor.");
    }
  }

  public void seleccionarNuevoCanal(int canal)
  {
    if (!this.encendida)
    {
      System.out.println("El televisor esta apagado.");
      return;
    }
    if (canal < MIN_CANAL || canal > MAX_CANAL)
      System.out.println("No se puede seleccionar ese canal.");
    else
    {
      this.canal = canal;
      System.out.println("Canal seleccionado.");
    }
  }

  public int obtenerCanal()
  {
    if (!this.encendida)
    {
      System.out.println("El televisor esta apagado.");
      return 0;
    }
    return this.canal;
  }

  public void subirCanal()
  {
    if (!this.encendida)
    {
      System.out.println("El televisor esta apagado.");
      return;
    }
    if (this.canal == MAX_CANAL)
      System.out.println("No se puede subir el canal.");
    else
    {
      this.canal++;
      System.out.println("Canal subido.");
    }
  }

  public void bajarCanal()
  {
    if (!this.encendida)
    {
      System.out.println("El televisor esta apagado.");
      return;
    }
    if (this.canal == MIN_CANAL)
      System.out.println("No se puede bajar el canal.");
    else
    {
      this.canal--;
      System.out.println("Canal bajado.");
    }
  }

  public void cambiarVolumen(int volumen)
  {
    if (!this.encendida)
    {
      System.out.println("El televisor esta apagado.");
      return;
    }
    if (volumen < MIN_VOL || volumen > MAX_VOL)
      System.out.println("No se puede cambiar a ese volumen.");
    else
    {
      this.volumen = volumen;
      System.out.println("Volumen asignado.");
    }
  }

  public void imprimirCaracteristicas()
  {
    System.out.println(
      "Marca: " + marca + "\n" +
      "Modelo: " + modelo + "\n" +
      "Anio: " + anio + "\n" +
      "Panoramica: " + panoramica + "\n" +
      "Estereo: " + stereo + "\n" +
      "Encendida: " + encendida + "\n" +
      "Volumen: " + volumen + "\n" +
      "Canal: " + canal
    );
  }
}
