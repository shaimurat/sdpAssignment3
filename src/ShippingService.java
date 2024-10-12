public class ShippingService {


    public double calculateShipping(String productId, int quantity, String destination) {
        double baseCharge = 5.00;
        double perItemCharge = 1.50;
        double totalCharge = baseCharge + (perItemCharge * quantity);
        System.out.println("Calculated shipping charge: $" + totalCharge + " to " + destination);
        return totalCharge;
    }

    public boolean arrangeShipping(String productId, int quantity, String destination) throws ShippingException {
        System.out.println("Arranging shipping for " + quantity + " unit(s) of product ID " + productId + " to " + destination + "...");

        boolean success = true;

        if (success) {
            System.out.println("Shipping arranged successfully.");
            return true;
        } else {
            throw new ShippingException("Shipping arrangement failed.");
        }
    }
}
