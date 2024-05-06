public class LoyaltySystem {
    
    private double discount;
    private String loyaltyStatus;

    public LoyaltySystem(String loyaltyStatus){
        this.loyaltyStatus = loyaltyStatus;
        setDiscountState();       
    }

    public void setDiscountState() {
        switch (loyaltyStatus) {
            case "Regular":
                discount = 0.0;
                break;
        
            case "Silver":
                discount = 0.1;
                break;

            case "Gold":
                discount = 0.2;
                break;

            default:
                System.out.println("Loyalty Status not found or incorrect");
                break;
        }
    }

    public double applyDiscount(double totalCost){
        System.out.println("\nCustomer Loyalty Status - " + loyaltyStatus);
        System.out.println("Discount applied - " + discount * 100 + "%");
        totalCost -= (totalCost * discount);
        return totalCost;
    }
}