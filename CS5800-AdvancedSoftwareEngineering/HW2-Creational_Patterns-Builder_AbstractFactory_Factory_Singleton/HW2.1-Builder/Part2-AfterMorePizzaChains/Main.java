public class Main {
  public static void main(String[] args) {

    Pizza largePizzaHutPizza3topping = new PizzaBuilder("Large")
        .setPizzaHut()
        .addChicken()
        .addOnions()
        .addExtraCheese()
        .build();

    Pizza smallPizzaHutPizza2topping = new PizzaBuilder("Small")
        .setPizzaHut()
        .addChicken()
        .addExtraCheese()
        .build();

    Pizza mediumLittleCaesarsPizza8topping = new PizzaBuilder("Medium")
        .setLittleCaesars()
        .addChicken()
        .addOnions()
        .addExtraCheese()
        .addMushrooms()
        .addPeppers()
        .addSpinach()
        .addOlives()
        .addPesto()
        .build();

    Pizza smallLittleCaesarsPizza6topping = new PizzaBuilder("Small")
        .setLittleCaesars()
        .addChicken()
        .addOnions()
        .addExtraCheese()
        .addMushrooms()
        .addPeppers()
        .addOlives()
        .build();

    Pizza smallDominosPizza1topping = new PizzaBuilder("Small")
        .setDominos()
        .addChicken()
        .build();

    Pizza largeDominosPizza3topping = new PizzaBuilder("Large")
        .setDominos()
        .addChicken()
        .addExtraCheese()
        .addMushrooms()
        .build();

    largePizzaHutPizza3topping.eat();
    smallPizzaHutPizza2topping.eat();

    mediumLittleCaesarsPizza8topping.eat();
    smallLittleCaesarsPizza6topping.eat();

    smallDominosPizza1topping.eat();
    largeDominosPizza3topping.eat();

  }
}
