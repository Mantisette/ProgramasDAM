package progbloque2.tarea08bicicletas;

public enum Extra
{

  RUEDA_GORDA(90),
  GUARDABARROS(30),
  LUCES(40),
  SOPORTE_MOVIL(20);

  final double costeExtra;

  Extra(double costeExtra)
  {
    this.costeExtra = costeExtra;
  }
}
