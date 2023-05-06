import java.util.ArrayList;

public class VendingMachine {

    private StateOfVendingMachine stateOfVendingMachine;
    private Snack selectedSnack;
    private double money;
    private SnackDispenseHandler snackDispenseHandler;
    private ArrayList<Snack> snacks;

    public VendingMachine() {
        this.stateOfVendingMachine = new IdleState();
        this.selectedSnack = null;
        this.money = 0;
        this.snackDispenseHandler = new CokeDispenseHandler(
            new PepsiDispenseHandler(
                            new CheetosDispenseHandler(
                                            new DoritosDispenseHandler(
                                                            new KitkatDispenseHandler(
                                                                            new SnickersDispenseHandler(
                                                                                            null))))));

        this.snacks = new ArrayList<>();;
    }

    public StateOfVendingMachine getStateOfVendingMachine() {
        return stateOfVendingMachine;
    }

    public void setStateOfVendingMachine(StateOfVendingMachine stateOfVendingMachine) {
        this.stateOfVendingMachine = stateOfVendingMachine;
    }

    public Snack getSelectedSnack() {
        return selectedSnack;
    }

    public void setSelectedSnack(Snack selectedSnack) {
        this.selectedSnack = selectedSnack;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public SnackDispenseHandler getSnackDispenseHandler() {
        return snackDispenseHandler;
    }

    public void setSnackDispenseHandler(SnackDispenseHandler snackDispenseHandler) {
        this.snackDispenseHandler = snackDispenseHandler;
    }

    public ArrayList<Snack> getSnacks() {
        return snacks;
    }

    public void setSnacks(ArrayList<Snack> snacks) {
        this.snacks = snacks;
    }

    public void addSnack(Snack snack) {
        snacks.add(snack);
    }

    public void idle() {
        getStateOfVendingMachine().idle(this);
    }

    public void waitingForSelection(Snack snack) {
        this.setSelectedSnack(snack);
        getStateOfVendingMachine().waitingForSelection(this);
    }

    public void waitingForMoney(double money) {
        this.setMoney(money);
        getStateOfVendingMachine().waitingForMoney(this);
    }

    public void dispensingSnack() {
        getStateOfVendingMachine().dispensingSnack(this);
    }

    public void printAllSnacks() {
        String allSnackOptions = "Options: ";
        for (Snack snack : getSnacks()) {
            allSnackOptions += "\n   " + snack.toString();
        }
        System.out.println(allSnackOptions);
    }

}
