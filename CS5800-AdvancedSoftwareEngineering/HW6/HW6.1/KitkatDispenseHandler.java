
public class KitkatDispenseHandler extends SnackDispenseHandler {

    public KitkatDispenseHandler(SnackDispenseHandler next) {
        super(next);
    }

    public void dispenseSnack(Snack snack) {
        if (snack.getName() == "Kitkat") {
            System.out.println("Dispensing Kitkat...");
            snack.setQuantity(snack.getQuantity() - 1);
        } else {
            super.dispenseSnack(snack);
        }
    }
}