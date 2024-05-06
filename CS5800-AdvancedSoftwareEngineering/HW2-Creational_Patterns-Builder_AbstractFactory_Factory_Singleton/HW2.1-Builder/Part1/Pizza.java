import java.util.ArrayList;

public class Pizza {
  private String pizzaSize;
  private ArrayList<String> toppings;

  public Pizza(String pizzaSize) {
    this.pizzaSize = pizzaSize;
    this.toppings = new ArrayList<String>();
  }

  public void addTopping(String topping) {
    toppings.add(topping);
  }

  public void eat() {
    System.out.println("\n" + pizzaSize + " Pizza ordered from Pizza Hut with Toppings:");
    for (String topping : toppings) {
      System.out.println("-" + topping);
    }
  }
}