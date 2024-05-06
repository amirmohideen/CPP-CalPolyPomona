public class MastercraftBoatFactory implements BoatFactory {
  private static BoatFactory instance = null;

  private MastercraftBoatFactory() {
  }

  public static BoatFactory getInstance() {
    if (instance == null) {
      instance = new MastercraftBoatFactory();
    }
    return instance;
  }

  @Override
  public void build() {
    System.out.println("Mastercraft built a boat.");
  }

  @Override
  public void repair() {
    System.out.println("Mastercraft repaired a boat.");
  }

  @Override
  public void restore() {
    System.out.println("Mastercraft restored a boat.");
  }
}