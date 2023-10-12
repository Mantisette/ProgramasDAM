package progbloque3.tarea05ajedrez;

public enum Pieza
{

  PEON("Peon", 8, 1),
  CABALLO("Caballo", 2, 2),
  ALFIL("Alfil", 2, 3),
  TORRE("Torre", 2, 5),
  DAMA("Dama", 1, 9);

  final String nombre;
  final int limitePiezas;
  final int valor;
  int restantes;

  Pieza(String nombre, int limitePiezas, int valor)
  {
    this.nombre = nombre;
    this.limitePiezas = limitePiezas;
    this.valor = valor;
    restantes = limitePiezas;
  }
}
