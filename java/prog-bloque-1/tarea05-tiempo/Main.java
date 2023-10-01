package progbloque1.tarea07tiempo;

public class Main
{

  public static void main(String[] args)
  {
    Tiempo t1 = new Tiempo(2, 10, 46);
    System.out.println("t1: " + t1);
    Tiempo t2 = new Tiempo(0, 40, 20);
    System.out.println("t2: " + t2);
    Tiempo t3 = new Tiempo(3, 25, 10);
    System.out.println("t3: " + t3);
    System.out.println();

    Tiempo t4 = t1.suma(t2);
    System.out.println("t4: " + t4);
    Tiempo t5 = t4.resta(t2);
    System.out.println("t5: " + t5);
    System.out.println();

    Tiempo t6 = new Tiempo(4, -65, -70);
    System.out.println("t6: " + t6);
    Tiempo t7 = new Tiempo(-4, -65, -70);
    System.out.println("t7: " + t7);
  }
}
