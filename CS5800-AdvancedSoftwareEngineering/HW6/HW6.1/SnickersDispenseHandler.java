public class SnickersDispenseHandler extends SnackDispenseHandler {

    public SnickersDispenseHandler(SnackDispenseHandler next) {
        super(next);
    }

    public void dispenseSnack(Snack snack) {
        if (snack.getName() == "Snickers") {
            System.out.println("Dispensing Snickers...");
            snack.setQuantity(snack.getQuantity() - 1);
        } else {
            super.dispenseSnack(snack);
        }
    }
}