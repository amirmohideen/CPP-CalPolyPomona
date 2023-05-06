public class Main {
        public static void main(String[] args) {

                Snack coke = new Snack("Coke", 1.00, 6);
                Snack pepsi = new Snack("Pepsi", 1.50, 5);
                Snack cheetos = new Snack("Cheetos", 2.00, 4);
                Snack doritos = new Snack("Doritos", 2.50, 3);
                Snack kitkat = new Snack("Kitkat", 3.00, 2);
                Snack snickers = new Snack("Snickers", 3.50, 1);

                VendingMachine vendingMachine = new VendingMachine();
                vendingMachine.addSnack(coke);
                vendingMachine.addSnack(pepsi);
                vendingMachine.addSnack(cheetos);
                vendingMachine.addSnack(doritos);
                vendingMachine.addSnack(kitkat);
                vendingMachine.addSnack(snickers);

                System.out.println("\n[[[Case 1: Money is enough and snack is available]]]\n");
                vendingMachine.idle();
                vendingMachine.waitingForSelection(coke);
                vendingMachine.waitingForMoney(2);
                vendingMachine.dispensingSnack();

                System.out.println("\n[[[Case 2: Money is not enough]]]\n");
                vendingMachine.idle();
                vendingMachine.waitingForSelection(snickers);
                vendingMachine.waitingForMoney(3);
                //vendingMachine.dispensingSnack();

                System.out.println("\n[[[Case 3: Case where the quantity hits 0 with snickers]]]\n");
                vendingMachine.idle();
                vendingMachine.waitingForSelection(snickers);
                vendingMachine.waitingForMoney(3.5);
                vendingMachine.dispensingSnack();

                System.out.println("\n[[[Case 4: Case where quantity is 0 for Snickers]]]\n");
                vendingMachine.idle();
                vendingMachine.waitingForSelection(snickers);
                vendingMachine.waitingForMoney(3.5);
                vendingMachine.dispensingSnack();
        }
}
