public class Chicken extends Topping {
    public Chicken(Food foodItem) {
        super(foodItem);
    }

    public double getCost() {
        return super.getCost() + 3.0;
    }

    public String getDescription() {
        return super.getDescription() + " (with Chicken)";
    }
}
