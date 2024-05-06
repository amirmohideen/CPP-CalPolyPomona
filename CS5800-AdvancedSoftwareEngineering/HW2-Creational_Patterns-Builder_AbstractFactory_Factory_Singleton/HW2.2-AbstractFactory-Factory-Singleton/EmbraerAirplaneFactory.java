public class EmbraerAirplaneFactory implements AirplaneFactory {
  private static AirplaneFactory instance = null;

  private EmbraerAirplaneFactory() {
  }

  public static AirplaneFactory getInstance() {
    if (instance == null) {
      instance = new EmbraerAirplaneFactory();
    }
    return instance;
  }

  @Override
  public void build() {
    System.out.println("Embraer built an airplane.");
  }

  @Override
  public void repair() {
    System.out.println("Embraer repaired an airplane.");
  }

  @Override
  public void restore() {
    System.out.println("Embraer restored an airplane.");
  }
}