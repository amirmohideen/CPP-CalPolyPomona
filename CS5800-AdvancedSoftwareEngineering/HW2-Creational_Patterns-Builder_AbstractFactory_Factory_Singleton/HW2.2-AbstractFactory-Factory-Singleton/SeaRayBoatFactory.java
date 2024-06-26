public class SeaRayBoatFactory implements BoatFactory {
  private static BoatFactory instance = null;

  private SeaRayBoatFactory() {
  }

  public static BoatFactory getInstance() {
    if (instance == null) {
      instance = new SeaRayBoatFactory();
    }
    return instance;
  }

  @Override
  public void build() {
    System.out.println("SeaRay built a boat.");
  }

  @Override
  public void repair() {
    System.out.println("SeaRay repaired a boat.");
  }

  @Override
  public void restore() {
    System.out.println("SeaRay restored a boat.");
  }
}