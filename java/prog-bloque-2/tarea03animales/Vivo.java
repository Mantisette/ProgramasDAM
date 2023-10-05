package progbloque2.tarea03animales;

public interface Vivo
{

  default void comer()
  {
    System.out.println(this + ": comiendo");
  }
  default void dormir()
  {
    System.out.println(this + ": ZZZZZ");
  }
}
