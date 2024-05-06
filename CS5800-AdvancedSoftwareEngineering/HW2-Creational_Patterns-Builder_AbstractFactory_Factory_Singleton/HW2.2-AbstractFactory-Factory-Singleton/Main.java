public class Main {
  public static void main(String[] args) {

    System.out.println("\nCAR FACTORIES:");

    CarFactory hondaCarFactory = TransportFactory.createCarFactory("Honda");
    CarFactory porscheCarFactory = TransportFactory.createCarFactory("Porsche");
    CarFactory teslaCarFactory = TransportFactory.createCarFactory("Tesla");

    System.out.println("");
    hondaCarFactory.build();
    hondaCarFactory.repair();
    hondaCarFactory.restore();
    System.out.println("");

    porscheCarFactory.build();
    porscheCarFactory.repair();
    porscheCarFactory.restore();
    System.out.println("");

    teslaCarFactory.build();
    teslaCarFactory.repair();
    teslaCarFactory.restore();
    System.out.println("");

    CarFactory teslaCarFactory2 = TransportFactory.createCarFactory("Tesla");
    System.out.println(teslaCarFactory.toString());
    System.out.println(teslaCarFactory2.toString());
    System.out.println((teslaCarFactory == teslaCarFactory2));
    System.out.println("Attempt to create second Tesla Car Instance failed since both variables point to same address");

    System.out.println("\nAIRPLANE FACTORIES:");

    AirplaneFactory airbusAirplaneFactory = TransportFactory.createAirplaneFactory("Airbus");
    AirplaneFactory boeingAirplaneFactory = TransportFactory.createAirplaneFactory("Boeing");
    AirplaneFactory embraerAirplaneFactory = TransportFactory.createAirplaneFactory("Embraer");

    System.out.println("");
    airbusAirplaneFactory.build();
    airbusAirplaneFactory.repair();
    airbusAirplaneFactory.restore();
    System.out.println("");

    boeingAirplaneFactory.build();
    boeingAirplaneFactory.repair();
    boeingAirplaneFactory.restore();
    System.out.println("");

    embraerAirplaneFactory.build();
    embraerAirplaneFactory.repair();
    embraerAirplaneFactory.restore();
    System.out.println("");

    AirplaneFactory airbusAirplaneFactory2 = TransportFactory.createAirplaneFactory("Airbus");

    System.out.println(airbusAirplaneFactory.toString());
    System.out.println(airbusAirplaneFactory2.toString());
    System.out.println((airbusAirplaneFactory == airbusAirplaneFactory2));
    System.out
        .println("Attempt to create second Airbus Airplane Instance failed since both variables point to same address");

    System.out.println("\nBOAT FACTORIES:");

    BoatFactory seaRayBoatFactory = TransportFactory.createBoatFactory("SeaRay");
    BoatFactory mastercraftBoatFactory = TransportFactory.createBoatFactory("MasterCraft");
    BoatFactory bertramBoatFactory = TransportFactory.createBoatFactory("Bertram");

    System.out.println("");
    seaRayBoatFactory.build();
    seaRayBoatFactory.repair();
    seaRayBoatFactory.restore();
    System.out.println("");

    mastercraftBoatFactory.build();
    mastercraftBoatFactory.repair();
    mastercraftBoatFactory.restore();
    System.out.println("");

    bertramBoatFactory.build();
    bertramBoatFactory.repair();
    bertramBoatFactory.restore();
    System.out.println("");

  }
}
