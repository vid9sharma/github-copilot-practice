package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages the inventory of products.
 */
public class InventoryManager {

  // Map to store products
  private Map<Integer, Product> inventory;

  // Constructor
  public InventoryManager() {
    this.inventory = new HashMap<>();
  }

  /**
   * Adds a product to the inventory.
   *
   * @param id       The ID of the product.
   * @param name     The name of the product.
   * @param quantity The quantity of the product.
   */
  public void addProduct(int id, String name, int quantity) {
    inventory.put(id, new Product(id, name, quantity));
  }

  /**
   * Removes a product from the inventory.
   *
   * @param id The ID of the product to remove.
   * @throws IllegalArgumentException if the product ID does not exist.
   */
  public void removeProduct(int id) {
    if (inventory.containsKey(id)) {
      inventory.remove(id);
    } else {
      throw new IllegalArgumentException("Product ID not found: " + id);
    }
  }

  /**
   * Lists all products in the inventory.
   *
   * @return A list of all products.
   */
  public List<Product> listProducts() {
    return new ArrayList<>(inventory.values());
  }

  /**
   * Updates the quantity of a product in the inventory.
   *
   * @param id       The ID of the product.
   * @param quantity The new quantity of the product.
   * @throws IllegalArgumentException if the product ID does not exist.
   */
  public void updateProductQuantity(int id, int quantity) {
    Product product = inventory.get(id);
    if (product != null) {
      product.setQuantity(quantity);
    } else {
      throw new IllegalArgumentException("Product ID not found: " + id);
    }
  }

  // Main method for testing
  public static void main(String[] args) {
    InventoryManager inventoryManager = new InventoryManager();
    inventoryManager.addProduct(1, "Apple", 10);
    inventoryManager.addProduct(2, "Banana", 20);
    inventoryManager.addProduct(3, "Orange", 15);
    inventoryManager.updateProductQuantity(2, 25);
    inventoryManager.removeProduct(3);
    List<Product> products = inventoryManager.listProducts();
    for (Product product : products) {
      System.out.println(product);
    }
  }
}