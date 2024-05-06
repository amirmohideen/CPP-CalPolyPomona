public class Topping implements Food {
    private Food topping;

    public Topping(Food topping) {
        this.topping = topping;
    }

    public String getDescription() {
        return topping.getDescription();
    }

    public double getCost() {
        return topping.getCost();
    }
}
