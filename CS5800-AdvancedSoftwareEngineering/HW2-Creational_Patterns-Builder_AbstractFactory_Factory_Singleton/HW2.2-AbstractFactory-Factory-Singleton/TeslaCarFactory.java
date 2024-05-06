public class TeslaCarFactory implements CarFactory {
  private static CarFactory instance = null;

  private TeslaCarFactory() {
  }

  public static CarFactory getInstance() {
    if (instance == null) {
      instance = new TeslaCarFactory();
    }
    return instance;
  }

  @Override
  public void build() {
    System.out.println("Tesla built a car");
  }

  @Override
  public void repair() {
    System.out.println("Tesla repaired a car");
  }

  @Override
  public void restore() {
    System.out.println("Tesla restored a car");
  }
}