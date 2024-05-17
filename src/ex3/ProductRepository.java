package ex3;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class ProductRepository {
    private final List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public List<Product> sortProductsByName() {
        return products.stream()
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
    }

    public List<Product> sortProductsByPriceDescending() {
        return products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .collect(Collectors.toList());
    }

    public boolean areAllProductsExpensive(double threshold) {
        return products.stream()
                .allMatch(product -> product.getPrice() > threshold);
    }

    public boolean isAnyProductCheap(double threshold) {
        return products.stream()
                .anyMatch(product -> product.getPrice() < threshold);
    }

    public List<Product> findProductsByNameContaining(String searchTerm) {
        return products.stream()
                .filter(product -> product.getName().toLowerCase().contains(searchTerm.toLowerCase()))
                .collect(Collectors.toList());
    }
}