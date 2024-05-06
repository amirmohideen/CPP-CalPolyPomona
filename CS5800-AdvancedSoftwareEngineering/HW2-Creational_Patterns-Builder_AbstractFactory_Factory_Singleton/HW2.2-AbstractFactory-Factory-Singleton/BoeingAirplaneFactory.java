public class BoeingAirplaneFactory implements AirplaneFactory {
  private static AirplaneFactory instance = null;

  private BoeingAirplaneFactory() {
  }

  public static AirplaneFactory getInstance() {
    if (instance == null) {
      instance = new BoeingAirplaneFactory();
    }
    return instance;
  }

  @Override
  public void build() {
    System.out.println("Boeing built an airplane.");
  }

  @Override
  public void repair() {
    System.out.println("Boeing repaired an airplane.");
  }

  @Override
  public void restore() {
    System.out.println("Boeing restored an airplane.");
  }
}