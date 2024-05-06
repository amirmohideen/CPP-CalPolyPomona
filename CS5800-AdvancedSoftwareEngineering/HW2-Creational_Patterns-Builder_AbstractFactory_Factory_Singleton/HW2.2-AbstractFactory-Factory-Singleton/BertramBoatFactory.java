public class BertramBoatFactory implements BoatFactory {
  private static BoatFactory instance = null;

  private BertramBoatFactory() {
  }

  public static BoatFactory getInstance() {
    if (instance == null) {
      instance = new BertramBoatFactory();
    }
    return instance;
  }

  @Override
  public void build() {
    System.out.println("Bertram built a boat.");
  }

  @Override
  public void repair() {
    System.out.println("Bertram repaired a boat.");
  }

  @Override
  public void restore() {
    System.out.println("Bertram restored a boat.");
  }
}