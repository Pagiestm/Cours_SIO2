package main.java.fr.pgah.slam4;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nom;
    private List<Chambre> chambres;
    private int nbChambres;

    public Hotel(String nom, int nbChambres, int nbEtages) {
        this.nom = nom;
        this.nbChambres = nbChambres;
        this.chambres = creerChambres(nbChambres, nbEtages);
    }

    public int getNbChambres() {
        return nbChambres;
    }

    public int nbChambresOccupees() {
        int nbChambresOccupees = 0;
        // Pour chaque chambre
        // for (int i = 0; i < chambres.size(); i++) {
        // // si la chambre est occupée
        // if (chambres.get(i).estOccupee()) {
        // nbChambresOccupees++;
        // }
        // }

        // Pour chaque chambre
        for (Chambre chambre : chambres) {
            if (chambre.estOccupee()) {
                nbChambresOccupees++;
            }
        }

        // renvoyer nbChambresOccupees
        return nbChambresOccupees;
    }

    private List<Chambre> creerChambres(int nbChambres, int nbEtages) {
        List<Chambre> chambres = new ArrayList<>();

        int nbChambresParEtage = nbChambres / nbEtages;
        // Pour chaque étage
        for (int numEtage = 1; numEtage <= nbEtages; numEtage++) {
            // Pour chaque chambre de l'étage
            for (int compteurChambre = 0; compteurChambre < nbChambresParEtage; compteurChambre++) {
                Chambre chambre = creerChambre(nbChambresParEtage, numEtage, compteurChambre);
                chambres.add(chambre);
            }
        }
        return chambres;
    }

    private Chambre creerChambre(int nbChambresParEtage, int numEtage, int compteurChambre) {
        int numChambre = numEtage * 100 + compteurChambre;
        TypeChambre type = TypeChambre.DOUBLE;
        if (compteurChambre <= 3) {
            type = TypeChambre.SIMPLE;
        } else {
            if (compteurChambre == nbChambresParEtage - 1) {
                type = TypeChambre.SUITE;
            }
        }
        Chambre chambre = new Chambre(numChambre, type);
        return chambre;
    }

    public double tauxOccupation() {
        double taux = nbChambresOccupees() / nbChambres * 100;
        return taux;
    }

    public boolean louerChambre(TypeChambre typeAttendu, String nom, int nbJours) {
        boolean resultat = false;
        // Pour chaque chambre
        for (Chambre chambre : chambres) {
            // si la chambre est libre et correspond au type attendu
            if (chambre.estLibre() && chambre.correspondAuType(typeAttendu)) {
                // louer la chambre au client et renvoyer VRAI
                chambre.definirOccupant(nom, nbJours);
                resultat = true;
                break;
            }
        }
        // renvoyer FAUX
        return resultat;
    }

    public void joursSuivant(int nbJoursRestants, String nom){
        //Pour chaque chambre
        //dire à la chambre qu'on passe au jour suivant
        for (Chambre chambre : chambres){
            chambre.jourSuivant();
        }
    }

    public String toString() {
        String res = "Nom de l'Hôtel : " + nom;
        for (Chambre chambre : chambres){
            System.out.println(chambre);
        }
        res += "\n\nNombre de chambres occupées : " + nbChambresOccupees();
        res += "\n\nTaux d'occupation : " + tauxOccupation();
        return res;
    }

    public void jourSuivant() {
    }
}
