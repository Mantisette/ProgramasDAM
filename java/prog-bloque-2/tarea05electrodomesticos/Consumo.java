package progbloque2.tarea05electrodomesticos;

public enum Consumo
{

  C("C", 0),
  B("B", 0),
  A("A", 10),
  A_PLUS("A+", 25),
  A_PLUS_PLUS("A++", 50);

  final String consumo;
  final double precio;

  Consumo(String consumo, double precio)
  {
    this.consumo = consumo;
    this.precio = precio;
  }
}
