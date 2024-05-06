public class Tomato extends Topping {
    public Tomato(Food foodItem) {
        super(foodItem);
    }

    public double getCost() {
        return super.getCost() + 1.0;
    }

    public String getDescription() {
        return super.getDescription() + " (with Tomato)";
    }
}
