public class PizzaBuilder {
  private Pizza pizza;

  public PizzaBuilder(String pizzaSize) {
    pizza = new Pizza(pizzaSize);
  }

  public PizzaBuilder setPizzaHut() {
    pizza.setPizzaChain("Pizza Hut");
    return this;
  }

  public PizzaBuilder setLittleCaesars() {
    pizza.setPizzaChain("Little Caesars");
    return this;
  }

  public PizzaBuilder setDominos() {
    pizza.setPizzaChain("Dominos");
    return this;
  }

  public PizzaBuilder addPepperoni() {
    pizza.addTopping("Pepperoni");
    return this;
  }

  public PizzaBuilder addSausage() {
    pizza.addTopping("Sausage");
    return this;
  }

  public PizzaBuilder addMushrooms() {
    pizza.addTopping("Mushrooms");
    return this;
  }

  public PizzaBuilder addBacon() {
    pizza.addTopping("Bacon");
    return this;
  }

  public PizzaBuilder addOnions() {
    pizza.addTopping("Onions");
    return this;
  }

  public PizzaBuilder addExtraCheese() {
    pizza.addTopping("Extra Cheese");
    return this;
  }

  public PizzaBuilder addPeppers() {
    pizza.addTopping("Peppers");
    return this;
  }

  public PizzaBuilder addChicken() {
    pizza.addTopping("Chicken");
    return this;
  }

  public PizzaBuilder addOlives() {
    pizza.addTopping("Olives");
    return this;
  }

  public PizzaBuilder addSpinach() {
    pizza.addTopping("Spinach");
    return this;
  }

  public PizzaBuilder addTomatoAndBasil() {
    pizza.addTopping("Tomato and Basil");
    return this;
  }

  public PizzaBuilder addBeef() {
    pizza.addTopping("Beef");
    return this;
  }

  public PizzaBuilder addHam() {
    pizza.addTopping("Ham");
    return this;
  }

  public PizzaBuilder addPesto() {
    pizza.addTopping("Pesto");
    return this;
  }

  public PizzaBuilder addSpicyPork() {
    pizza.addTopping("Spicy Pork");
    return this;
  }

  public PizzaBuilder addHamAndPineapple() {
    pizza.addTopping("Ham and Pineapple");
    return this;
  }

  public Pizza build() {
    if (pizza.getPizzaChain() == null) {
      System.out.println("Order Cancelled: pizza chain was not set");
    }
    return pizza;
  }

}