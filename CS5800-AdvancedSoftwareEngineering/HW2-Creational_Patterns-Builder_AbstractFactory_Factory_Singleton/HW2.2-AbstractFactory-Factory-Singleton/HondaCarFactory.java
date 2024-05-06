public class HondaCarFactory implements CarFactory {
  private static CarFactory instance = null;

  private HondaCarFactory() {
  }

  public static CarFactory getInstance() {
    if (instance == null) {
      instance = new HondaCarFactory();
    }
    return instance;
  }

  @Override
  public void build() {
    System.out.println("Honda built a car");
  }

  @Override
  public void repair() {
    System.out.println("Honda repaired a car");
  }

  @Override
  public void restore() {
    System.out.println("Honda restored a car");
  }
}