package progbloque4.tarea02_2excepcionesp2;

public class Main
{

  public static void main(String[] args)
  {
    Gato var1 = new Gato("Varon 1", 3, Sexo.V);
    Gato var2 = new Gato("Varon 2", 3, Sexo.V);
    Gato hem1 = new Gato("Hembra 1", 3, Sexo.H);
    Gato hem2 = new Gato("Hembra 2", 3, Sexo.H);
    Gato cria = null;

    try
    {
      cria = var2.aparearCon(var1);
    }
    catch (ApareamientoImposibleException e)
    {
      System.out.println(e.getMessage());
    }

    System.out.println(cria);
  }
}
