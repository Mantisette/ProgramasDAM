package progbloque3.tarea08diccionario;

import java.util.HashMap;
import java.util.Scanner;

public class Main
{

  public static void main(String[] args)
  {
    HashMap<String, String> diccionario = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    diccionario.put("coche", "car");
    diccionario.put("gato", "cat");
    diccionario.put("perro", "dog");
    diccionario.put("casa", "house");
    diccionario.put("humano", "human");
    diccionario.put("madre", "mother");
    diccionario.put("padre", "father");
    diccionario.put("dinero", "money");
    diccionario.put("vida", "life");
    diccionario.put("médico", "medic");

    while (true)
    {
      System.out.println("Introduzca una palabra en español para ver su traducción");
      String palabra = sc.nextLine();
      if (palabra.equals("salir"))
        return;

      if (diccionario.containsKey(palabra))
        System.out.println(diccionario.get(palabra));
      else
        System.out.println("La palabra introducida no está registrada.");
    }
  }
}
