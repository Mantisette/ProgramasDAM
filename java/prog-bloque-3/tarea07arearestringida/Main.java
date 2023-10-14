package progbloque3.tarea07arearestringida;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Main
{

  public static void main(String[] args)
  {
    final int MAX_INTENTOS = 3;

    HashMap<String, String> credenciales = new HashMap<>();

    Scanner sc = new Scanner(System.in);
    String usuario;
    String pass;

    credenciales.put("Juan", "1234");
    credenciales.put("Ana", "Anna");
    credenciales.put("Carmen", "siluro");
    credenciales.put("Berto", "xxx");

    for (int i = 0; i < MAX_INTENTOS; i++)
    {
      System.out.println("Introduzca sus credenciales: ");
      System.out.print("Usuario: ");
      usuario = sc.nextLine();
      System.out.print("Contraseña: ");
      pass = sc.nextLine();

      if (Objects.equals(credenciales.get(usuario), pass))
      {
        System.out.println("Acceso permitido.");
        return;
      }
    }

    System.out.println("Acceso denegado.");
  }
}
