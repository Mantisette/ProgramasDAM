package progbloque2.tarea03animales;

public interface Amigable {

  default void seguir()
  {
    System.out.println(this + ": voy con mi dueño");
  }
  void jugar();
}
