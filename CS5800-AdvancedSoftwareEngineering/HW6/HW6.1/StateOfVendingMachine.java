public interface StateOfVendingMachine {
    void idle(VendingMachine vendingMachine);
    void waitingForSelection(VendingMachine vendingMachine);
    void waitingForMoney(VendingMachine vendingMachine);
    void dispensingSnack(VendingMachine vendingMachine);
}