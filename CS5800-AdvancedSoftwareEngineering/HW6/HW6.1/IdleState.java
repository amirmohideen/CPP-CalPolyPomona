
public class IdleState implements StateOfVendingMachine {

    public void idle(VendingMachine vendingMachine) {
        System.out.println("Press any button to Start...");
        vendingMachine.setStateOfVendingMachine(new WaitingForSelectionState());
    }

    public void waitingForSelection(VendingMachine vendingMachine) {
        System.out.println("First, press a button");
    }

    public void waitingForMoney(VendingMachine vendingMachine) {
        System.out.println("First, press a button and select a snack");
    }

    public void dispensingSnack(VendingMachine vendingMachine) {
        System.out.println("First, press a button, select a snack and insert money");
    }

}