package fr.pgah;

import java.awt.*;

public class TigreBlanc extends Bestiole {

  private boolean AInfecte = false;

  public Action getAction(BestioleInfo info) {
    if (info.getEnFace() == Voisin.AUTRE) {
      AInfecte = true;
      return Action.INFECTER;
    } else if (info.getEnFace() == Voisin.MUR || info.getADroite() == Voisin.MUR) {
      return Action.GAUCHE;
    } else if (info.getEnFace() == Voisin.MEME) {
      return Action.DROITE;
    } else {
      return Action.SAUTER;
    }
  }

  //Toujours blanc
  public Color getCouleur() {
    return Color.WHITE;
  }

  //renvoie si le tigre est à déjà infecté infecté alors il devient "B" sinon il n'a toujours pas infecté "b"
  public String toString() {
    if (AInfecte){
      return "B";
    } else {
      return "b";
    }
  }
}
