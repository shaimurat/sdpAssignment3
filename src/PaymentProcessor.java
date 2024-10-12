public class PaymentProcessor {

    /**
     * Processes a payment.
     *
     * @param amount         The amount to be paid.
     * @param paymentMethod  The method of payment (e.g., Credit Card).
     * @return true if payment is successful.
     * @throws PaymentFailedException If the payment processing fails.
     */
    public boolean processPayment(double amount, String paymentMethod) throws PaymentFailedException {
        System.out.println("Processing payment of $" + amount + " using " + paymentMethod + "...");
        // Simulate payment processing
        // In a real system, integrate with payment gateways and handle failures
        // For simplicity, assume all payments succeed
        boolean success = true; // Simulated result

        if (success) {
            System.out.println("Payment processed successfully.");
            return true;
        } else {
            throw new PaymentFailedException("Payment processing failed.");
        }
    }
}