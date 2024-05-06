import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Food> listofOrders;

    public Order() {
        listofOrders = new ArrayList<>();
    }

    public void addMenuItem(Food food) {
        listofOrders.add(food);
    }

    public void getOrderDescription() {
        for (Food item : listofOrders) {
            System.out.println(item.getDescription() + " - $" + item.getCost());
        }
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (Food food : listofOrders) {
            totalCost += food.getCost();
        }
        return totalCost;
    }
    
}
