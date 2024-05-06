public class CruiseShip extends Ship {
  private int maxNumberofPassengers;

  CruiseShip() {
    this.maxNumberofPassengers = 0;
  }

  public void setMaxNumberofPassengers(int maxNumberofPassengers) {
    this.maxNumberofPassengers = maxNumberofPassengers;
  }

  public int getMaxNumberofPassengers() {
    return maxNumberofPassengers;
  }

  @Override
  public void printShipDetails() {
    System.out.println("Ship Name: " + super.getShipName() + ", Max Passengers: " + maxNumberofPassengers);
  }

}