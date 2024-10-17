package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

public class InventoryManagerTest {

  @Test
  public void addProductAddsProductToInventory() {
    InventoryManager inventoryManager = new InventoryManager();
    inventoryManager.addProduct(1, "Apple", 10);
    List<Product> products = inventoryManager.listProducts();
    assertEquals(1, products.size());
    assertEquals("Apple", products.get(0).getName());
  }

  @Test
  public void removeProductRemovesProductFromInventory() {
    InventoryManager inventoryManager = new InventoryManager();
    inventoryManager.addProduct(1, "Apple", 10);
    inventoryManager.removeProduct(1);
    List<Product> products = inventoryManager.listProducts();
    assertTrue(products.isEmpty());
  }

  @Test
  public void removeProductThrowsExceptionForInvalidId() {
    InventoryManager inventoryManager = new InventoryManager();
    try {
      inventoryManager.removeProduct(999);
      fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Product ID not found: 999", e.getMessage());
    }
  }

  @Test
  public void updateProductQuantityUpdatesQuantity() {
    InventoryManager inventoryManager = new InventoryManager();
    inventoryManager.addProduct(1, "Apple", 10);
    inventoryManager.updateProductQuantity(1, 20);
    List<Product> products = inventoryManager.listProducts();
    assertEquals(20, products.get(0).getQuantity());
  }

  @Test
  public void updateProductQuantityThrowsExceptionForInvalidId() {
    InventoryManager inventoryManager = new InventoryManager();
    try {
      inventoryManager.updateProductQuantity(999, 20);
      fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Product ID not found: 999", e.getMessage());
    }
  }

  @Test
  public void listProductsReturnsAllProducts() {
    InventoryManager inventoryManager = new InventoryManager();
    inventoryManager.addProduct(1, "Apple", 10);
    inventoryManager.addProduct(2, "Banana", 20);
    List<Product> products = inventoryManager.listProducts();
    assertEquals(2, products.size());
  }
}