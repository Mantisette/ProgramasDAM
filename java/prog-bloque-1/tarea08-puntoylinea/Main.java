package progbloque1.tarea08puntoylinea;

public class Main {

  public static void main(String[] args) {
    Punto p1 = new Punto(4.21, 7.3);
    Punto p2 = new Punto(-2, 1.66);
    System.out.println(p1);
    System.out.println(p2);

    Linea l = new Linea(p1, p2);
    System.out.println(l);
  }
}
