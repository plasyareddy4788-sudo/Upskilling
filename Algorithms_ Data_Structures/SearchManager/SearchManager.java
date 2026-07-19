import java.util.Arrays;

class Product implements Comparable<Product> {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }

    @Override
    public int compareTo(Product other) {
        return this.productName.compareTo(other.productName);
    }

    @Override
    public String toString() {
        return "ID: " + productId + " | Name: " + productName + " | Category: " + category;
    }
}

public class SearchManager {

    public static int linearSearch(Product[] products, String targetName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName().equalsIgnoreCase(targetName)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] unsortedProducts = {
            new Product("P101", "Wireless Mouse", "Electronics"),
            new Product("P102", "Mechanical Keyboard", "Electronics"),
            new Product("P103", "Gaming Monitor", "Electronics"),
            new Product("P104", "Bluetooth Speaker", "Audio"),
            new Product("P105", "Leather Wallet", "Accessories")
        };

        Product[] sortedProducts = Arrays.copyOf(unsortedProducts, unsortedProducts.length);
        Arrays.sort(sortedProducts);

        System.out.println("--- Linear Search Demonstration ---");
        String searchTarget1 = "Gaming Monitor";
        int indexLinear = linearSearch(unsortedProducts, searchTarget1);
        if (indexLinear != -1) {
            System.out.println("Found '" + searchTarget1 + "' at index " + indexLinear + ":");
            System.out.println(unsortedProducts[indexLinear]);
        } else {
            System.out.println("'" + searchTarget1 + "' not found.");
        }

        System.out.println("\n--- Binary Search Demonstration ---");
        String searchTarget2 = "Mechanical Keyboard";
        int indexBinary = binarySearch(sortedProducts, searchTarget2);
        if (indexBinary != -1) {
            System.out.println("Found '" + searchTarget2 + "' at index " + indexBinary + " (Sorted Array):");
            System.out.println(sortedProducts[indexBinary]);
        } else {
            System.out.println("'" + searchTarget2 + "' not found.");
        }
    }
}