class Square implements PaymentGateway{
  private String locationID;

  Square(String locationID) {
    this.locationID = locationID;
  }

  @Override
  public void getGatewayName(){
    System.out.println("Payment Processor used: Square");
  }

  public void printGatewayDetails(){
    System.out.println("Location ID: " + locationID + "\n");
  }

}