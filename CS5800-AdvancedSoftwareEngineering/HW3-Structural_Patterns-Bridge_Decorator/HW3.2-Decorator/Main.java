public class Main {
    public static void main(String[] args) {

        Food burger = new Chicken(new Cheese(new Tomato(new Burger())));
        Food fries = new Fries();
        Food drink = new Drink();

        Order order = new Order();
        order.addMenuItem(burger);
        order.addMenuItem(fries);
        order.addMenuItem(drink);
        
        System.out.println("Food Ordered: ");
        order.getOrderDescription();

        double totalOrderCost = order.getTotalCost();
        System.out.println("Total Order Cost - $" + totalOrderCost);

        LoyaltySystem loyaltyDiscount = new LoyaltySystem("Gold");
        double discountedTotalCost = loyaltyDiscount.applyDiscount(totalOrderCost);
        System.out.println("\nDiscounted Total Order Cost - $" + discountedTotalCost);
       
    }
}
