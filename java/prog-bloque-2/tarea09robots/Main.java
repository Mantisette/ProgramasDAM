package progbloque2.tarea09robots;

public class Main
{

  public static void main(String[] args)
  {
    Robot[] almacen = new Robot[]
      {
        new Androide(),
        new Barrefondos(),
        new Androide(),
        new Barrefondos(),
        new Androide()
      };

    for (Robot robot : almacen)
    {
      robot.encender();
      robot.apagar();
    }

    System.out.println("---------------------");

    Vida [] simcity = new Vida[]
      {
        new Humano("Ana"),
        new Androide(),
        new Humano("Bea"),
        new Androide(),
        new Humano("Carlos"),
        new Androide()
      };

    for (Vida vida : simcity)
    {
      System.out.println("---------------------");
      vida.identificarTipoSelf();
      vida.identificarNombreSelf();
      vida.saludar();
      vida.reir();
      vida.llorar();
      System.out.println("---------------------");
    }
  }
}
