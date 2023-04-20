class Main {
  public static void main(String[] args) {

    PaymentGateway payPal = new Paypal("amirmohideen@gmail.com");
    PaymentGateway stripe = new Stripe("Amir", "5105105105105100", "03/25");
    PaymentGateway square = new Square("ChIJgUbEo8");
   
    double paymentAmount = 89.5;
    PaymentGatewayProcessor payPalAdapter = new PaymentAdaptor(paymentAmount, payPal);
    PaymentGatewayProcessor stripeAdapter = new PaymentAdaptor(paymentAmount, stripe);
    PaymentGatewayProcessor squareAdapter = new PaymentAdaptor(paymentAmount, square);
   
    payPalAdapter.processPayment();
    stripeAdapter.processPayment();
    squareAdapter.processPayment();

  }
}