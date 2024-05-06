public class CargoShip extends Ship {

  private int cargoCapacityinTonnage;

  CargoShip() {
    this.cargoCapacityinTonnage = 0;
  }

  public void setCargoCapacityinTonnage(int cargoCapacityinTonnage) {
    this.cargoCapacityinTonnage = cargoCapacityinTonnage;
  }

  public int getCargoCapacityinTonnage() {
    return cargoCapacityinTonnage;
  }

  @Override
  public void printShipDetails() {
    System.out.println("Ship Name: " + super.getShipName() + ", Cargo Capacity (Tonnes): " + cargoCapacityinTonnage);
  }
}