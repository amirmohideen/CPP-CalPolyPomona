public class Main {
  public static void main(String[] args) {

    Pizza smallPizza3toppings = new PizzaBuilder("Small")
        .addChicken()
        .addOnions()
        .addExtraCheese()
        .build();
    smallPizza3toppings.eat();

    Pizza mediumPizza6toppings = new PizzaBuilder("Medium")
        .addChicken()
        .addOnions()
        .addExtraCheese()
        .addMushrooms()
        .addPeppers()
        .addSpinach()
        .build();
    mediumPizza6toppings.eat();

    Pizza largePizza9toppings = new PizzaBuilder("Large")
        .addChicken()
        .addOnions()
        .addExtraCheese()
        .addMushrooms()
        .addPeppers()
        .addSpinach()
        .addOlives()
        .addTomatoAndBasil()
        .addPesto()
        .build();
    largePizza9toppings.eat();

  }
}
