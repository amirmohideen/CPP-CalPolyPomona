class Paypal implements PaymentGateway {
  private String userEmail;

  Paypal(String userEmail) {
    this.userEmail = userEmail;
  }

  @Override
  public void getGatewayName() {
    System.out.println("Payment Processor used: PayPal");
  }

  @Override
  public void printGatewayDetails() {
    System.out.println("User Email: " + userEmail + "\n");
  }

}