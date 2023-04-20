class Stripe implements PaymentGateway {
    private String cardholderName;
    private String cardNumber;
    private String expirationDate;

    Stripe(String cardholderName, String cardNumber,
            String expirationDate) {
        this.cardholderName = cardholderName;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    @Override
    public void getGatewayName() {
        System.out.println("Payment Processor used: Stripe");
    }

    @Override
    public void printGatewayDetails() {
        System.out.println("Cardholder Name: " + cardholderName + "\nCard Number: " + cardNumber
                + "\nExpiration Date: " + expirationDate + "\n");

    }

}