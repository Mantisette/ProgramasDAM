package progbloque2.tarea03animales;

public class Main
{

  public static void main(String[] args)
  {
    Vaca vaca = new Vaca();
    Oveja oveja = new Oveja();
    Cabra cabra = new Cabra();
    Perro perro = new Perro("Sultan");
    Gato gato = new Gato("Golfo");
    Periquito periquito = new Periquito("Piolin");

    vaca.comer();
    vaca.dormir();
    vaca.producir();

    oveja.comer();
    oveja.dormir();
    oveja.producir();

    cabra.comer();
    cabra.dormir();
    cabra.producir();
    cabra.seguir();
    cabra.jugar();

    perro.comer();
    perro.dormir();
    perro.producir();
    perro.seguir();
    perro.jugar();

    gato.comer();
    gato.dormir();
    gato.producir();
    gato.seguir();
    gato.jugar();

    periquito.comer();
    periquito.dormir();
    periquito.seguir();
    periquito.jugar();

    System.out.println("-----------");

    Productivo[] factory = new Productivo[]
      {
        new Vaca(), new Oveja(), new Cabra(), new Perro("Toby"),
        new Gato("Magma")
      };

    for (Productivo animal : factory)
      animal.producir();
  }
}
