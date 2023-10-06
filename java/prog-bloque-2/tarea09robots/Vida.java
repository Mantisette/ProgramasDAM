package progbloque2.tarea09robots;

public interface Vida
{

  void identificarNombreSelf();

  default void identificarTipoSelf()
  {
    System.out.println("Soy un " + this.getClass().getSimpleName());
  }

  void saludar();

  default void reir()
  {
    System.out.println(this + ": ¡Ja, Ja!");
  }

  void llorar();
}
