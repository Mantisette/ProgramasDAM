package progbloque2.tarea01fabrica;

public class Coche
{

  private final String matricula;
  private final Modelo modelo;

  public Coche()
  {
    this.matricula = makeMatricula();
    this.modelo = Modelo.getRandom();
  }

  public static String makeMatricula()
  {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < 3; i++)
      sb.append((int)(Math.random()*9)+1); // tres numeros de 1 a 9
    sb.append("-");
    for (int i = 0; i < 4; i++)
      sb.append((char)(Math.random()*25+65)); // cuatro letras de 'A' a 'Z'

    return sb.toString();
  }

  @Override
  public String toString()
  {
    return matricula + ": " + modelo;
  }
}
