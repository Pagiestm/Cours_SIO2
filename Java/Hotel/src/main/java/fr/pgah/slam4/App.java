package fr.pgah.slam4;
public final class App {

  public static void main(String[] args) {

    // Chambre

    //Chambre chambre = new Chambre(123, TypeChambre.SIMPLE);
    //chambre.definirOccupant("Jean-Pierre", 2);
    //System.out.println(chambre.toString());
    //chambre.jourSuivant();
    //if (chambre.estOccupee()) {
      //System.out.println("La chambre est louée");
    //}
    //System.out.println(chambre.toString());
    //chambre.jourSuivant();
    //System.out.println(chambre.toString());
    //chambre.jourSuivant();
    //System.out.println(chambre.toString());
    //if (chambre.estOccupee()) {
      //System.out.println("La chambre est louée");
    //}

    // Hotel

    Hotel hotel = new Hotel("Hotel du Nord", 14, 2);

    System.out.println(hotel.toString());

    hotel.louerChambre(TypeChambre.SIMPLE, "M. SIMPLE", 3);
    hotel.louerChambre(TypeChambre.SUITE, "Mme. SUITE", 5);
    hotel.louerChambre(TypeChambre.DOUBLE, "Mme. DOUBLE", 1);
    System.out.println(hotel.toString());

    hotel.jourSuivant();
    hotel.jourSuivant();
    System.out.println(hotel.toString());
  }
}
