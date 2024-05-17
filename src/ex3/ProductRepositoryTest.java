package ex3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductRepositoryTest {
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
        productRepository.addProduct(new Product(1, "Laptop", 2000.0, "Electronics"));
        productRepository.addProduct(new Product(2, "Mouse", 130.0, "Electronics"));
        productRepository.addProduct(new Product(3, "Keyboard", 110.0, "Electronics"));
        productRepository.addProduct(new Product(4, "Chair", 150.0, "Furniture"));
        productRepository.addProduct(new Product(5, "Table", 300.0, "Furniture"));
    }

    @Test
    void testSortProductsByName() {
        List<Product> sortedProducts = productRepository.sortProductsByName();
        assertEquals("Chair", sortedProducts.get(0).getName());
        assertEquals("Keyboard", sortedProducts.get(1).getName());
        assertEquals("Laptop", sortedProducts.get(2).getName());
        assertEquals("Mouse", sortedProducts.get(3).getName());
        assertEquals("Table", sortedProducts.get(4).getName());
    }

    @Test
    void testSortProductsByPriceDescending() {
        List<Product> sortedProducts = productRepository.sortProductsByPriceDescending();
        assertEquals("Laptop", sortedProducts.get(0).getName());
        assertEquals("Table", sortedProducts.get(1).getName());
        assertEquals("Chair", sortedProducts.get(2).getName());
        assertEquals("Mouse", sortedProducts.get(3).getName());
        assertEquals("Keyboard", sortedProducts.get(4).getName());
    }

    @Test
    void testAreAllProductsExpensive() {
        assertTrue(productRepository.areAllProductsExpensive(100.0));
        assertFalse(productRepository.areAllProductsExpensive(200.0));
    }

    @Test
    void testIsAnyProductCheap() {
        assertTrue(productRepository.isAnyProductCheap(120.0));
        assertFalse(productRepository.isAnyProductCheap(50.0));
    }

    @Test
    void testFindProductsByNameContaining() {
        List<Product> foundProducts = productRepository.findProductsByNameContaining("key");
        assertEquals(1, foundProducts.size());
        assertEquals("Keyboard", foundProducts.get(0).getName());
    }
}

