package progbloque2.tarea01fabrica;

public enum Modelo
{

  PANDA5 ("Panda", Cilindrada.MINIMA, Puertas.FAMILIAR),
  PANDA3 ("Panda", Cilindrada.MENOR, Puertas.HATCHBACK),
  RONDA ("Ronda", Cilindrada.MEDIA, Puertas.FAMILIAR),
  MALAGA ("Malaga", Cilindrada.MEDIA, Puertas.FAMILIAR),
  TOLEDO ("Toledo", Cilindrada.MAYOR, Puertas.FAMILIAR),
  ATECA ("Ateca", Cilindrada.MAYOR, Puertas.FAMILIAR),
  LEON ("Leon", Cilindrada.MAYOR, Puertas.FAMILIAR),
  LEON_VIP ("Leon", Cilindrada.MAXIMA, Puertas.FAMILIAR);

  private final String nombre;
  private final Cilindrada cilindrada;
  private final Puertas puertas;

  Modelo(String nombre, Cilindrada cilindrada, Puertas puertas)
  {
    this.nombre = nombre;
    this.cilindrada = cilindrada;
    this.puertas = puertas;
  }

  public String toString()
  {
    return nombre + " " + cilindrada + " " + puertas;
  }

  public static Modelo getRandom()
  {
    return values()[(int) (Math.random() * values().length)];
  }
}
