
public class WaitingForMoneyState implements StateOfVendingMachine {

    public void idle(VendingMachine vendingMachine) {
        System.out.println("Machine reset to idle");
    }

    public void waitingForSelection(VendingMachine vendingMachine) {
        System.out.println("First, insert money for current order");
    }

    public void waitingForMoney(VendingMachine vendingMachine) {
        System.out.println("\nWaiting for Money...");

        double money = vendingMachine.getMoney();
        System.out.println("Received $" + money);

        double price = vendingMachine.getSelectedSnack().getPrice();
        if (money >= price) {
            vendingMachine.setStateOfVendingMachine(new DispensingSnackState());
        } else {
            vendingMachine.setStateOfVendingMachine(new IdleState());
            System.out.println("$" + money + " not enough! \nReturning $" + money);
            vendingMachine.setMoney(0);
            vendingMachine.setSelectedSnack(null);
        }
    }

    public void dispensingSnack(VendingMachine vendingMachine) {
        System.out.println("First, insert money for current order");
    }

}