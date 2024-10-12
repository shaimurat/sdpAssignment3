//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ShoppingFacade facade = new ShoppingFacade();
        String productId = "P001";
        int quantity = 2;
        String paymentMethod = "Credit Card";
        String destination = "123 Main St, Anytown, USA";
        System.out.println("Placing order...");
        String confirmation = facade.placeOrder(productId, quantity, paymentMethod, destination);
        System.out.println(confirmation);
    }
}