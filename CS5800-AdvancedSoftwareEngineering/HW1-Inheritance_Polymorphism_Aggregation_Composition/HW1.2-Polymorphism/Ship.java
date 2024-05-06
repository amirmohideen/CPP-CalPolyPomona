public class Ship {
  private String shipName;
  private String shipYear;

  Ship() {
    this.shipName = "";
    this.shipYear = "";
  }

  public void setShipName(String shipName) {
    this.shipName = shipName;
  }

  public String getShipName() {
    return shipName;
  }

  public void setShipYear(String shipYear) {
    this.shipYear = shipYear;
  }

  public String getShipYear() {
    return shipYear;
  }

  public void printShipDetails() {
    System.out.println("\nShip Name: " + shipName + ", Year: " + shipYear);
  }
}