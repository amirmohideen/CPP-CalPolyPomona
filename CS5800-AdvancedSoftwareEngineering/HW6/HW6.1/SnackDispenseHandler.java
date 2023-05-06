public abstract class SnackDispenseHandler {
    private SnackDispenseHandler next;

    public SnackDispenseHandler(SnackDispenseHandler next) {
        this.next = next;
    }

    public void dispenseSnack(Snack snack) {
        if (next != null) {
            next.dispenseSnack(snack);
        }
    }
}