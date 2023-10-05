package progbloque2.tarea03animales;

public abstract class Animal implements Vivo
{

  int id;
  String tipo;

  public Animal(int count)
  {
    this.id = count;
    this.tipo = this.getClass().getSimpleName() + "-" + id;
  }

  @Override
  public String toString()
  {
    return tipo;
  }
}
