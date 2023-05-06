
public class WaitingForSelectionState implements StateOfVendingMachine {

    public void idle(VendingMachine vendingMachine) {
        System.out.println("Machine reset to idle");
    }

    public void waitingForSelection(VendingMachine vendingMachine) {
        System.out.println("\nSelect a snack!");
        vendingMachine.printAllSnacks();

        System.out.println("\nSelected - " + vendingMachine.getSelectedSnack());
        vendingMachine.setStateOfVendingMachine(new WaitingForMoneyState());
    }

    public void waitingForMoney(VendingMachine vendingMachine) {
        System.out.println("First, select a snack");
    }

    public void dispensingSnack(VendingMachine vendingMachine) {
        System.out.println("First, select a snack and insert money");
    }

}