import java.util.HashMap;
import java.util.Map;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}

public class InventoryManager {
    private Map<String, Product> inventory;

    public InventoryManager() {
        this.inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(String productId, int newQuantity, double newPrice) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
        }
    }

    public void deleteProduct(String productId) {
        inventory.remove(productId);
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        for (Product p : inventory.values()) {
            System.out.println("ID: " + p.getProductId() + 
                               " | Name: " + p.getProductName() + 
                               " | Qty: " + p.getQuantity() + 
                               " | Price: $" + p.getPrice());
        }
    }

    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        Product prod1 = new Product("P001", "Laptop", 10, 999.99);
        Product prod2 = new Product("P002", "Smartphone", 25, 499.99);
        manager.addProduct(prod1);
        manager.addProduct(prod2);
        System.out.println("--- Initial Inventory ---");
        manager.displayInventory();

        manager.updateProduct("P001", 8, 949.99);
        System.out.println("\n--- After Updating Laptop ---");
        manager.displayInventory();

        manager.deleteProduct("P002");
        System.out.println("\n--- After Deleting Smartphone ---");
        manager.displayInventory();
    }
}