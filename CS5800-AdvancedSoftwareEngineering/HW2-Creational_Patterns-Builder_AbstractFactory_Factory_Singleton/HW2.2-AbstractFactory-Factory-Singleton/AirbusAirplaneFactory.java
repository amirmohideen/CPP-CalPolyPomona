public class AirbusAirplaneFactory implements AirplaneFactory {
  private static AirplaneFactory instance = null;

  private AirbusAirplaneFactory() {
  }

  public static AirplaneFactory getInstance() {
    if (instance == null) {
      instance = new AirbusAirplaneFactory();
    }
    return instance;
  }

  @Override
  public void build() {
    System.out.println("Airbus built an airplane.");
  }

  @Override
  public void repair() {
    System.out.println("Airbus repaired an airplane.");
  }

  @Override
  public void restore() {
    System.out.println("Airbus restored an airplane.");
  }
}