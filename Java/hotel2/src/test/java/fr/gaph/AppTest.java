package fr.gaph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class App {
    @Test
    //CONTEXTE_METHODE_RESULTATATTENDU()
    void hotelVide_tauxOccupation_doitRenvoyerZeroes() {
        //Pattern AAA - Arranger/Agir/Assert

        //ARRANGER

        Hotel hotel = new Hotel("Vide", 14, 2);

        //AGIR

        double tauxEffectif = hotel.tauxOccupation();

        //ASSERT

        assertEquals(0.0, tauxEffectif, "Un hotel vide devrait avoir un taux d'occupation à 0");
    }

    @Test
    //CONTEXTE_METHODE_RESULTATATTENDU()
    void hotelPlein_tauxOccupation_doitRenvoyer100() {
        //Pattern AAA - Arranger/Agir/Assert

        //ARRANGER

        Hotel hotel = new Hotel("Plein", 4, 2);
        hotel.louerChambre(TypeChambre.SIMPLE, "toto", 1);
        hotel.louerChambre(TypeChambre.SIMPLE, "toto", 1);
        hotel.louerChambre(TypeChambre.SIMPLE, "toto", 1);
        hotel.louerChambre(TypeChambre.SIMPLE, "toto", 1);
        hotel.louerChambre(TypeChambre.SIMPLE, "toto", 1);
        hotel.louerChambre(TypeChambre.SUITE, "toto", 1);

        //AGIR

        double tauxEffectif = hotel.tauxOccupation();

        //ASSERT

        assertEquals(100.0, tauxEffectif, "Un hotel plein devrait avoir un taux d'occupation à 100");
    }

    @Test
    //CONTEXTE_METHODE_RESULTATATTENDU()
    void hotelAMoitiePlein_tauxOccupation_doitRenvoyer50() {
        //Pattern AAA - Arranger/Agir/Assert

        //ARRANGER

        Hotel hotel = new Hotel("à moitié plein", 6, 1);
        hotel.louerChambre(TypeChambre.SIMPLE, "toto", 1);
        hotel.louerChambre(TypeChambre.DOUBLE, "toto", 1);
        hotel.louerChambre(TypeChambre.SUITE, "toto", 1);

        //AGIR

        double tauxEffectif = hotel.tauxOccupation();

        //ASSERT

        assertEquals(50.0, tauxEffectif, "Un hotel à moitié plein devrait avoir un taux d'occupation à 50");
    }
}