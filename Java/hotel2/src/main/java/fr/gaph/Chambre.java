package fr.gaph;

public class Chambre {
  private int numero;
  private int joursRestants;
  private TypeChambre type;
  private String nomOccupant;

  public Chambre(int numero, TypeChambre type) {
    this.numero = numero;
    this.type = type;
    joursRestants = 0;
    nomOccupant = null;
  }

  public boolean definirOccupant(String nom, int nbJours) {
    if (estOccupee()) {
      return false;
    }
    nomOccupant = nom;
    joursRestants = nbJours;
    return true;
  }

  public boolean estLibre() {
    return !estOccupee();
  }

  public boolean estOccupee() {
    return nomOccupant != null;
  }

  public void jourSuivant() {
    if (joursRestants > 0) {
      joursRestants--;
    }
    if (joursRestants == 0) {
      nomOccupant = null;
    }
  }

  public String toString() {
    String str = "Chambre " + numero + " : "
        + type.toString().toLowerCase()
        + " - ";
    // if (estLouée()) {
    // str += "louée";
    //str += " (" + nomOccupant + ")";
    // } else {
    // str += "libre";
    // }
    str += estOccupee() ? "louée (" + nomOccupant + ")" : "libre";
    return str;
  }

  public boolean correspondAuType(TypeChambre type){
    return type == this.type;
  }
}

