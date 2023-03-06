package fr.pgah;

import java.awt.*;

public class Yeti extends Bestiole {

  //définit le nombre de mouvements dans une phase
  private static final int nbMouvementParPhase = 6;

  //tableau qui contient les différents caractères représentant chaque phase
  private static final char[] PHASES = {'Y', 'E', 'T', 'I'};

  //variables qui sont utilisées pour déterminer quelle phase et quel mouvement de la phase actuelle doivent être affichés
  private int phase = 0;
  private int mouvementCount = 0;

  public Action getAction(BestioleInfo info) {
    if (info.getEnFace() == Voisin.AUTRE) {
      return Action.INFECTER;
    } else if (info.getEnFace() == Voisin.RIEN) {
      return Action.SAUTER;
    } else {
      return Action.DROITE;
    }
  }

  //renvoie la couleur gris
  public Color getCouleur() {
    return Color.GRAY;
  }

  //permet de renvoyer le caractère de la phase actuelle
  public String toString() {
    char phaseChar = PHASES[phase];
    //La variable mouvementCount est incrémentée à chaque appel et utilisée pour déterminer si la phase actuelle doit être mise à jour
    mouvementCount = (mouvementCount + 1) % nbMouvementParPhase;
    //Si mouvementCount est un multiple de nbMouvementParPhase, la phase est incrémentée et mouvementCount est remis à zéro
    if (mouvementCount == 0) {
        phase = (phase + 1) % PHASES.length;
    }
    return Character.toString(phaseChar);
  }
}
