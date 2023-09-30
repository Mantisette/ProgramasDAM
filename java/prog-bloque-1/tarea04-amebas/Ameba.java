package com.csm.amebas;

public class Ameba {
  public static final int PESO_INICIAL = 3;
  private static int countAmebas = 1;

  private final int id;
  private int peso;

  public Ameba() {
    id = countAmebas++;
    peso = PESO_INICIAL;
  }

//  @Override
//  public String toString() {
//    return "Soy la ameba " + id + " y peso " + peso + " microgramos.";
//  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Soy la ameba ")
      .append(id)
      .append(" y peso ")
      .append(peso)
      .append(" microgramos");
    return sb.toString();
  }

  void come(int comida){
    this.peso--; // Fagocitar
    this.peso += comida; // Comer
  }

  void come(Ameba target) {
    this.come(target.peso);
    target.peso = 0;
  }
}