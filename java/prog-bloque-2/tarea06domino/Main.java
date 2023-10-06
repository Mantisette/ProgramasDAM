package progbloque2.tarea06domino;

public class Main
{

  public static void main(String[] args)
  {
    Ficha f1 = new Ficha(6, 1);
    Ficha f2 = new Ficha(0, 4);
    Ficha f3 = new Ficha(3, 3);
    Ficha f4 = new Ficha(0, 1);
    System.out.println(f1);
    System.out.println(f2);
    System.out.println(f3);
    System.out.println(f4);
    System.out.println(f2.voltea());
    System.out.println(f2.encaja(f4));
    System.out.println(f1.encaja(f4));
    System.out.println(f1.encaja(f3));
    System.out.println(f1.encaja(f2));
  }
}
