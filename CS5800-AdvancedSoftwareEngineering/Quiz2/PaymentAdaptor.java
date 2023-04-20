class PaymentAdaptor implements PaymentGatewayProcessor {
  private double paymentAmount;
  private PaymentGateway gateway;

  public PaymentAdaptor(double paymentAmount, PaymentGateway gateway) {
    this.paymentAmount = paymentAmount;
    this.gateway = gateway;
  }

  @Override
  public void processPayment() {
    System.out.println("Processed Payment Amount of $" + paymentAmount);
    gateway.getGatewayName();
    gateway.printGatewayDetails();
  }

}