package fr.pgah;

import java.awt.*;

public class Ours extends Bestiole {

  private boolean polaire;
  private boolean slash = true;

  //Constructeur qui initialise l'attribut correspondant
  public Ours(boolean polaire) {
    this.polaire = polaire;
  }

  public Action getAction(BestioleInfo info) {
    if (info.getEnFace() == Voisin.AUTRE) {
      return Action.INFECTER;
    } else if (info.getEnFace() == Voisin.RIEN) {
      return Action.SAUTER;
    } else {
      return Action.GAUCHE;
    }
  }

  //méthode qui renvoie si l'ours est blanc (polaire) ou noir (normal)
  public Color getCouleur() {
    return polaire ? Color.WHITE : Color.BLACK;
  }

  //alterne à chaque mouvement entre / et \ (en commençant avec un slash /)
  public String toString() {
      slash = !slash;
      return slash ? "/" : "\\";
  }
}
