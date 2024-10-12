import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<String, Integer> inventory;

    public InventoryManager() {
        inventory = new HashMap<>();
        inventory.put("P001", 10);
        inventory.put("P002", 5);
        inventory.put("P003", 20);
        inventory.put("P004", 15);
    }

    public boolean checkStock(String productId, int quantity) throws InsufficientStockException {
        int available = inventory.getOrDefault(productId, 0);
        if (available >= quantity) {
            System.out.println("Stock available for product ID " + productId + ": " + available + " units.");
            return true;
        } else {
            throw new InsufficientStockException("Insufficient stock for product ID " + productId + ". Available: " + available + ", Requested: " + quantity);
        }
    }

    public void updateStock(String productId, int quantity) throws InsufficientStockException {
        int available = inventory.getOrDefault(productId, 0);
        if (available >= quantity) {
            inventory.put(productId, available - quantity);
            System.out.println("Stock updated for product ID " + productId + ". New stock: " + inventory.get(productId));
        } else {
            throw new InsufficientStockException("Cannot update stock for product ID " + productId + ". Insufficient stock.");
        }
    }
}

