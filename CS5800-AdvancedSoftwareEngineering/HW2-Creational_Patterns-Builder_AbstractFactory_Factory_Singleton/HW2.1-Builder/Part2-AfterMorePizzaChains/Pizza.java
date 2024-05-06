import java.util.ArrayList;

public class Pizza {

  private String pizzaSize;
  private ArrayList<String> toppings;
  private String pizzaChain;

  public Pizza(String pizzaSize) {
    this.toppings = new ArrayList<String>();
    this.pizzaChain = null;
    this.pizzaSize = pizzaSize;
  }

  public String getPizzaChain() {
    return pizzaChain;
  }

  public void setPizzaChain(String pizzaChain) {
    this.pizzaChain = pizzaChain;
  }

  public void addTopping(String topping) {
    toppings.add(topping);
  }

  public void eat() {
    System.out.println("\n" + pizzaSize + " Pizza ordered from " + pizzaChain + " with Toppings:");
    for (String topping : toppings) {
      System.out.println("-" + topping);
    }
  }
}