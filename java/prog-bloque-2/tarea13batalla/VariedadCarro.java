package progbloque2.tarea13batalla;

public enum VariedadCarro
{

  JEEP( 40, 100, 20),
  BLINDADO( 100, 500, 10),
  TANQUE( 200, 1000, 3);

  final int ataque;
  final int resistenciaInicial;
  final int usosIniciales;

  VariedadCarro(int ataque, int resistenciaInicial, int usosIniciales)
  {
    this.ataque = ataque;
    this.resistenciaInicial = resistenciaInicial;
    this.usosIniciales = usosIniciales;
  }
}
