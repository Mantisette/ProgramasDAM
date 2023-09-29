package progbloque1.tarea02fracciones;

public class Main
{

  public static void main(String[] args)
  {
    Fraccion[] lista = new Fraccion[20];
    int countFracciones = 0;

    Fraccion frac_0 = new Fraccion(2,3);
    lista[0] = frac_0;
    countFracciones++;

    Fraccion frac_1 = new Fraccion(1,2);
    lista[1] = frac_1;
    countFracciones++;

    Fraccion frac_2 = new Fraccion(0,0);
    lista[2] = frac_2;
    countFracciones++;

    Fraccion frac_3 = new Fraccion(-56,24);
    frac_3.invertir();
    lista[3] = frac_3;
    countFracciones++;

    Fraccion frac_4 = frac_0.multiplicarCopia(frac_1);
    lista[4] = frac_4;
    countFracciones++;

    Fraccion frac_5 = new Fraccion(32, 64);
    frac_5.reducir();
    lista[5] = frac_5;
    countFracciones++;

    System.out.println("FRACCIONES ALMACENADAS:");
    for (int i = 0; i < countFracciones; i++)
    {
      System.out.println(lista[i]);
    }
  }
}
