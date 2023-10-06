package progbloque2.tarea05electrodomesticos;

public class Main
{

  public static void main(String[] args)
  {
    Televisor t1 = new Televisor();
    Televisor t2 = new Televisor("Tele Grande", Color.NEGRO,
      Consumo.A_PLUS_PLUS, 1100, 80);

    Lavadora l3 = new Lavadora();
    Lavadora l4 = new Lavadora("Lavadora Industrial", Color.ACERO,
      Consumo.A_PLUS, 888.88, 15);

    Electrodomestico e5 = new Electrodomestico();
    Electrodomestico e6 = new Electrodomestico("Microondas de lo mas cutre",
      Color.AZUL, Consumo.C, 45.5);

    Electrodomestico[] almacenMain = Electrodomestico.getAlmacen();

    Electrodomestico.vender(2);
    Electrodomestico.vender(5);
    Electrodomestico.vender(200);
    Electrodomestico.vender(5);

    for(int i = 0; i < Electrodomestico.getCountElectrodomesticos(); i++)
      System.out.println(almacenMain[i]);

    System.out.println("Valor de lo vendido: " + Electrodomestico.calcularValorVendido() + "euros");
    System.out.println("Valor del stock: " + Electrodomestico.calcularValorStock() + "euros");
  }
}
