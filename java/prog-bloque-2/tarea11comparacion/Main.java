package progbloque2.tarea11comparacion;

import java.util.Arrays;
import java.util.Comparator;

public class Main
{

  public static void main(String[] args)
  {
    Persona[] simcity = new Persona[]
      {
        new Persona("123456", "123", "1234"),
        new Persona("1234", "123", "123"),
        null,
        new Persona("123", "123", "123"),
        new Persona("12", "123456", "123456"),
        new Persona("123", "123456", "123456"),
        null,
        new Persona("123", "123456", "12345")
      };

    System.out.println("Desordenado: ");
    for (Persona persona : simcity)
      System.out.println(persona);

    Arrays.sort(simcity, Comparator.nullsLast(Persona::compareTo));
    System.out.println("Ordenado: ");
    for (Persona persona : simcity)
      System.out.println(persona);
  }
}
