package progbloque1.tarea02fracciones;

public class Fraccion
{

  public static final int DENOMINADOR_DEFECTO = 1;

  private int numerador;
  private int denominador;

  public Fraccion(int numerador, int denominador)
  {
    if (denominador == 0)
    {
      System.out.println("Denominador invalido.");
      denominador = DENOMINADOR_DEFECTO;
    }
    fixSimboloDenominador(denominador);

    this.numerador = numerador;
    this.denominador = denominador;
  }

  void fixSimboloDenominador(int denominador)
  {
    if (denominador < 0)
    {
      System.out.println("Simbolos invalidos. Espere...");
      this.numerador = -(numerador);
      this.denominador = -(denominador);
    }
  }

  void invertir()
  {
    int aux = this.numerador;
    this.numerador = this.denominador;
    this.denominador = aux;
    fixSimboloDenominador(this.denominador);
  }

  Fraccion invertirCopia()
  {
    if (numerador == 0)
    {
      System.out.println("No se puede invertir, numerador 0.");
      return this;
    }
    fixSimboloDenominador(this.denominador);
    return new Fraccion(this.denominador, this.numerador);
  }

  void multiplicar(Fraccion multiplo)
  {
    this.numerador *= multiplo.numerador;
    this.denominador *= multiplo.denominador;
  }

  Fraccion multiplicarCopia(Fraccion multiplo)
  {
    return new Fraccion
      (
        this.numerador * multiplo.numerador,
        this.denominador * multiplo.denominador
      );
  }

  void dividir(Fraccion divisor)
  {
    // Dividir dos fracciones es equivalente a multiplicar por la inversa
    this.invertir();
    this.multiplicar(divisor);
  }

  Fraccion dividirCopia(Fraccion divisor)
  {
    Fraccion resultado = this.invertirCopia();
    resultado.multiplicar(divisor);
    return resultado;
  }

  void reducir()
  {
    if (checkNumeroPrimo(this.numerador) || checkNumeroPrimo(this.denominador))
      return;

    // Elegir el menor de los números para buscar un divisor con resto 0
    int menorDigito = Math.min(Math.abs(numerador), Math.abs(denominador));

    for (int i = menorDigito; i > 2; i--)
    {
      // Reducir si es posible
      if ((numerador % i == 0) && (denominador % i == 0))
      {
        numerador /= i;
        denominador /= i;
        System.out.printf("Reduciendo en %d\n", i);
      }
    }
    System.out.println("Reduccion finalizada.");
  }

  // Para reducir
  boolean checkNumeroPrimo(int numero)
  {
    if (numero <= 1)
      return false;

    for (int i = 2; i < numero-1; i++)
      if (numero % i == 0)
        return false;

    return true;
  }

  @Override
  public String toString()
  {
    return "Fraccion: " + numerador + "/" + denominador;
  }
}
