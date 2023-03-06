package com.example;

import java.util.Scanner;

public class Grille {

    static char touche = 'X';
    static char navire = '@';
    static char dansleau = 'O';
    static char eau = '-';


    static int grille[][] = new int[5][5];

    public static char etatDeLaGrille(int x, int y) {

        grille[1][2] = 1;
        grille[3][4] = 2;
        grille[3][2] = 3;

        if (grille[x][y] == 1) {
            return navire;
        } else if (grille[x][y] == 2) {
            return touche;
        } else if (grille[x][y] == 3) {
            return dansleau;
        } else {
            return eau;
        }
    }

    public static void afficherPlateau() {
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                System.out.print(etatDeLaGrille(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void Joueur() {
        try (Scanner scanner = new Scanner(System.in)) {
            for (int PlacerBateau = 0; PlacerBateau < 5; PlacerBateau++) {
                System.out.println("Placer un bateau : ");
                int nombre = scanner.nextInt();
                System.out.print("Nombreux total de bateau : " + nombre);
                System.out.println();
            }
        }
        Grille.afficherPlateau();
    }
}
