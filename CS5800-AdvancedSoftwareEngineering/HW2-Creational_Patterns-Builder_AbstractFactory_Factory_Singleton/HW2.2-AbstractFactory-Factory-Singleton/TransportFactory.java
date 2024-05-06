public class TransportFactory {

  public static CarFactory createCarFactory(String factoryType) {
    switch (factoryType) {
      case "Honda":
        return HondaCarFactory.getInstance();
      case "Tesla":
        return TeslaCarFactory.getInstance();
      case "Porsche":
        return PorscheCarFactory.getInstance();
      default:
        System.out.println("Wrong Car Factory type");
        return null;
    }
  }

  public static AirplaneFactory createAirplaneFactory(String factoryType) {
    switch (factoryType) {
      case "Boeing":
        return BoeingAirplaneFactory.getInstance();
      case "Embraer":
        return EmbraerAirplaneFactory.getInstance();
      case "Airbus":
        return AirbusAirplaneFactory.getInstance();
      default:
        System.out.println("Wrong Airplane Factory type");
        return null;
    }
  }

  public static BoatFactory createBoatFactory(String factoryType) {
    switch (factoryType) {
      case "SeaRay":
        return SeaRayBoatFactory.getInstance();
      case "MasterCraft":
        return MastercraftBoatFactory.getInstance();
      case "Bertram":
        return BertramBoatFactory.getInstance();
      default:
        System.out.println("Wrong Boat Factory type");
        return null;
    }

  }
}