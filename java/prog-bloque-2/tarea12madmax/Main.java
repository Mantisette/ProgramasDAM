package progbloque2.tarea12madmax;

public class Main
{

  public static void main(String[] args)
  {
    Coche c1 = new Coche(5);
    BiciMotor b1 = new BiciMotor();
    Mulo m1 = new Mulo();
    Coche c2 = new Coche(8);
    BiciMotor b2 = new BiciMotor();
    Mulo m2 = new Mulo();
    System.out.println(c1);
    System.out.println(b1);
    System.out.println(m1);
    System.out.println(c2);
    System.out.println(b2);
    System.out.println(m2);

    System.out.println("Stock gasolina: " + String.format("%.3f", Gasolina.getStock()) + "l.");


    System.out.println("\n------------ Usando el mulo -------");
    m1.montar(10);

    System.out.println("\n------------ Usando BiciMotor ecologicamente -------");
    b1.montar(2);

    System.out.println("\n------------ Usando BiciMotor con gasolina -------");
    Gasolina.usarCon(b1,  2);
    System.out.println("Stock gasolina: " + String.format("%.3f", Gasolina.getStock()) + "l.");
    Gasolina.fabricar(10);
    Gasolina.usarCon(b1,  2);
    System.out.println("Stock gasolina: " + String.format("%.3f", Gasolina.getStock()) + "l.");
    b1.conducir(4);
    System.out.println("Stock gasolina: " + String.format("%.3f", Gasolina.getStock()) + "l.");

    System.out.println("\n------------ Usando el coche -------");
    Gasolina.usarCon(c1,  100);
    System.out.println("Stock gasolina: " + String.format("%.3f", Gasolina.getStock()) + "l.");
    c1.conducir(50);
    System.out.println("Stock gasolina: " + String.format("%.3f", Gasolina.getStock()) + "l.");
    c1.conducir(200);

    System.out.println("\n------------ Resumen -------");
    System.out.println("Km totales: " + Vehiculo.getKmTotal());
  }
}
