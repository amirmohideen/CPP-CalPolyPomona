
public class DispensingSnackState implements StateOfVendingMachine {

    public void idle(VendingMachine vendingMachine) {
    }

    public void waitingForSelection(VendingMachine vendingMachine) {
    }

    public void waitingForMoney(VendingMachine vendingMachine) {
    }

    public void dispensingSnack(VendingMachine vendingMachine) {
        int quantity = vendingMachine.getSelectedSnack().getQuantity();
        double money = vendingMachine.getMoney();
        double price = vendingMachine.getSelectedSnack().getPrice();
        if (quantity - 1 >= 0) {
            vendingMachine.getSnackDispenseHandler().dispenseSnack(vendingMachine.getSelectedSnack());
            if (money > price) {
                System.out.println("Returning change $" + (money - price));
            }
        } else {
            System.out.println(
                    vendingMachine.getSelectedSnack().getName() + " out of stock, machine resetting to idle...");
            System.out.println("Returning $" + money);
        }
        vendingMachine.setStateOfVendingMachine(new IdleState());
        vendingMachine.setMoney(0.0);
        vendingMachine.setSelectedSnack(null);
    }

}