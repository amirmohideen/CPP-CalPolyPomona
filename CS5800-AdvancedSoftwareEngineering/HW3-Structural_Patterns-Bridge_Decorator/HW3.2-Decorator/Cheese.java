public class Cheese extends Topping {
    public Cheese(Food foodItem) {
        super(foodItem);
    }

    public double getCost() {
        return super.getCost() + 2.0;
    }

    public String getDescription() {
        return super.getDescription() + " (with Cheese)";
    }
}
