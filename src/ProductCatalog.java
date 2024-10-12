import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
    private Map<String, Product> products;

    public ProductCatalog() {
        products = new HashMap<>();
        products.put("P001", new Product("P001", "Laptop", 1200.00));
        products.put("P002", new Product("P002", "Smartphone", 800.00));
        products.put("P003", new Product("P003", "Headphones", 150.00));
        products.put("P004", new Product("P004", "Smartwatch", 200.00));
    }
    public Product searchProduct(String productId) throws ProductNotFoundException {
        Product product = products.get(productId);
        if (product != null) {
            System.out.println("Product found: " + product.getName() + " at $" + product.getPrice());
            return product;
        } else {
            throw new ProductNotFoundException("Product with ID " + productId + " not found.");
        }
    }
}