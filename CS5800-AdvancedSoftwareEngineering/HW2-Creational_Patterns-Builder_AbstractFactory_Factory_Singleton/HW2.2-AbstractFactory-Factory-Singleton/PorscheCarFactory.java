public class PorscheCarFactory implements CarFactory {
  private static CarFactory instance = null;

  private PorscheCarFactory() {
  }

  public static CarFactory getInstance() {
    if (instance == null) {
      instance = new PorscheCarFactory();
    }
    return instance;
  }

  @Override
  public void build() {
    System.out.println("Porsche built a car");
  }

  @Override
  public void repair() {
    System.out.println("Porsche repaired a car");
  }

  @Override
  public void restore() {
    System.out.println("Porsche restored a car");
  }
}