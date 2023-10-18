package progbloque4.tarea02_2excepcionesp2;

public class Gato
{

  public static final String SIN_RAZA= "Raza indefinida";
  // Public -> modificador de scope
  // Static -> variable definida a nivel de clase, compartida por todos los perros
  // Final -> constante, no cambia

  private String nombre;
  private final String raza;
  private double peso;
  private boolean agresivo;
  public final Sexo sexo;

  public Gato(String nombre, String raza, double peso, boolean agresivo, Sexo sexo)
  // Constructor base
  {
    this.nombre = nombre;
    this.raza = raza;
    this.peso = peso;
    this.agresivo = agresivo;
    this.sexo = sexo;
  }

  public Gato(String nombre, double peso, boolean agresivo, Sexo sexo)
  {
    this(nombre, SIN_RAZA, peso, agresivo, sexo);
  }

  public Gato(String nombre, String raza, double peso, Sexo sexo)
  {
    this(nombre, raza, peso, false, sexo);
  }

  public Gato(String nombre, double peso, Sexo sexo)
  {
    this(nombre, SIN_RAZA, peso, false, sexo);
  }

  static Gato clonarToNew(Gato source)
  {
    return new Gato (source.nombre, source.raza, source.peso, source.agresivo, source.sexo);
  }

  public void maullar()
  {
    System.out.println(nombre + ": miau!");
  }

  public void comer()
  {
    System.out.println(nombre + ": nom!");
    this.peso += .2;
  }

  public Gato aparearCon(Gato target) throws ApareamientoImposibleException
  {
    if (this.sexo == target.sexo)
      throw new ApareamientoImposibleException();
    else
    {
      System.out.println(this.nombre + ": apareando con " + target.nombre);
      return new Gato(this.nombre, target.raza, this.peso, target.agresivo, this.sexo);
    }
  }

  @Override
  public String toString()
  {
    return "Nombre: " + nombre + " - Raza: " + raza + " - Peso: " + peso +
      " - Agresivo: " + agresivo;
  }

  public String getNombre()
  {
    return nombre;
  }

  public void setNombre(String nombre)
  {
    this.nombre = nombre;
  }

  public String getRaza()
  {
    return raza;
  }

  public double getPeso()
  {
    return peso;
  }

  public void setPeso(double peso)
  {
    this.peso = peso;
  }

  public boolean getAgresivo()
  {
    return agresivo;
  }

  public void setAgresivo(boolean agresivo)
  {
    this.agresivo = agresivo;
  }
}
