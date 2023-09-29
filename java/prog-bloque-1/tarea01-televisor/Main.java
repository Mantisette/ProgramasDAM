package progbloque1.tarea01televisor;

public class Main {

  public static void main(String[] args) {
    Televisor t = new Televisor(
      "Samsung", "Modelo1", 2002, true, true
    );

    t.encender();
    t.apagar();
    t.imprimirCaracteristicas();
  }
}
