package progbloque1.tarea04amebas;

public class Ameba
{

  public static final int PESO_INICIAL = 3;

  private static int countAmebas = 1;

  private final int id;
  private int peso;

  public Ameba()
  {
    id = countAmebas++;
    peso = PESO_INICIAL;
  }

  @Override
  public String toString()
  {
    return "Soy la ameba " + id + " y peso " + peso + " microgramos.";
  }

  void come(int comida)
  {
    this.peso--; // Fagocitar
    this.peso += comida; // Comer
  }

  void come(Ameba objetivo)
  {
    this.come(objetivo.peso);
    objetivo.peso = 0;
  }
}
