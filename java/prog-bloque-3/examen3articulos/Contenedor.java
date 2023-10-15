package progbloque3.examen3articulos;

import java.util.HashSet;
import java.util.Iterator;

public class Contenedor<T>
{
  final String nombre;
  private final HashSet<T> contenido = new HashSet<>();

  public Contenedor(String nombre)
  {
    this.nombre = nombre;
  }

  @Override
  public String toString()
  {
    final StringBuilder sb = new StringBuilder("En el contenedor ");
    sb.append(nombre).append(" hay ").append(contenido.size()).append(" elementos");
    if (!contenido.isEmpty())
      for(T cosa:contenido)
        sb.append("\n\t").append(cosa);

    return sb.toString();
  }

  public boolean guardar(T target)

  {
    if (target == null)
      return false;
    if (contenido.contains(target))
      return false;

    contenido.add(target);
    return true;
  }

  public T sacar()

  {
    int random = (int)(Math.random() * contenido.size()+1);

    Iterator<T> buscaAleatorio = contenido.iterator();
    T sacando = null; // se va a sustituir

    for (int i = 0; i < random; i++)
      sacando = buscaAleatorio.next();
    buscaAleatorio.remove();

    return sacando;
  }

  public HashSet<T> sacarTodo()

  {
    HashSet<T> sacando = new HashSet<>(contenido);
    contenido.clear();
    return sacando;
  }
}
