package progbloque2.tarea08bicicletas;

public enum Tipo
{

  ALUMINIO(0),
  MADERA(100),
  CARBONO(150);

  final double costeTipo;

  Tipo(double costeTipo)
  {
    this.costeTipo = costeTipo;
  }
}
