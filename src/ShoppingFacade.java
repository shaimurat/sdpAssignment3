public class ShoppingFacade {
    private ProductCatalog productCatalog;
    private PaymentProcessor paymentProcessor;
    private InventoryManager inventoryManager;
    private ShippingService shippingService;

    public ShoppingFacade() {
        productCatalog = new ProductCatalog();
        paymentProcessor = new PaymentProcessor();
        inventoryManager = new InventoryManager();
        shippingService = new ShippingService();
    }

    public String placeOrder(String productId, int quantity, String paymentMethod, String destination) {
        try {
            Product product = productCatalog.searchProduct(productId);
            inventoryManager.checkStock(productId, quantity);
            double totalAmount = product.getPrice() * quantity;
            System.out.println("Total amount for " + quantity + " unit(s): $" + totalAmount);
            paymentProcessor.processPayment(totalAmount, paymentMethod);
            inventoryManager.updateStock(productId, quantity);
            double shippingCharge = shippingService.calculateShipping(productId, quantity, destination);
            totalAmount += shippingCharge;
            System.out.println("Total amount after shipping: $" + totalAmount);
            shippingService.arrangeShipping(productId, quantity, destination);
            String confirmation = "Order placed successfully for " + quantity + " unit(s) of product ID " + productId + ". Total Amount: $" + totalAmount;
            System.out.println(confirmation);
            return confirmation;
        } catch (ProductNotFoundException | InsufficientStockException | PaymentFailedException | ShippingException e) {
            String errorMessage = "Failed to place order: " + e.getMessage();
            System.out.println(errorMessage);
            return errorMessage;
        }
    }
}
