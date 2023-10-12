package progbloque3.tarea06conjuntoletras;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Principal
{

  public static void main(String[] args)
  {
    ArrayList<Letra> lista=new ArrayList<>();
    for (int i = 0; i < 1000; i++)
      lista.add(new Letra());

    System.out.println(lista);

    // Consigue un conjunto de 10 letras diferentes
    HashSet<Letra> letras = new HashSet<>();

    while (!lista.isEmpty())
    {
      int random = (int)(Math.random() * lista.size());
      Letra elegida = (lista.remove(random));
      letras.add(elegida);

      if (letras.size() >= 10) break;
    }

    System.out.println(letras);
  }
}
