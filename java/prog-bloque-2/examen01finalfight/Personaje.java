package progbloque2.examen01finalfight;

public abstract class Personaje
{

  private final String nombre;
  private int energia;
  //------------------------  CONSTRUCTORES ----------------------------------
  public Personaje(String nombre, int energia)
  {
    this.nombre = nombre;
    this.energia = energia;
  }
  //------------------------  ACCIONES ---------------------------------------
  abstract void atacar(Personaje p);
  abstract int recibirAtaque(int fuerza); //devuelve -1 si esquiva, 1 si muere, 0 si daño no letal
  final void decir(String mensaje)
  {
    System.out.println(nombre + ": " + mensaje);
  }
  //------------------------  GETTERS & SETTERS ------------------------------

  public String getNombre()
  {
    return nombre;
  }

  public int getEnergia()
  {
    return energia;
  }
  public void setEnergia(int energia)
  {
    this.energia = energia;
  }
}
