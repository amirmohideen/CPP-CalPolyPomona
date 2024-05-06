public class Main {
  public static void main(String[] args) {
    Ship[] ships = new Ship[3];

    ships[0] = new Ship();
    ships[0].setShipName("Titanic");
    ships[0].setShipYear("1909");

    ships[1] = new CruiseShip();
    ships[1].setShipName("Voyager");
    ships[1].setShipYear("1969");
    ((CruiseShip) ships[1]).setMaxNumberofPassengers(100);

    ships[2] = new CargoShip();
    ships[2].setShipName("Transporter");
    ships[2].setShipYear("1999");
    ((CargoShip) ships[2]).setCargoCapacityinTonnage(500);

    for (int i = 0; i < 3; i++) {
      ships[i].printShipDetails();
    }

  }
}