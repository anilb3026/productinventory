package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Product;



@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getProductId() == id) {
                return product;
            }
        }
        return null;
    }

    public Product updateProduct(int id, Product updatedProduct) {
        Product existingProduct = getProductById(id);

        if (existingProduct != null) {
            existingProduct.setProductName(
                updatedProduct.getProductName());
            existingProduct.setCategory(
                updatedProduct.getCategory());
            existingProduct.setStock(
                updatedProduct.getStock());
            existingProduct.setPrice(
                updatedProduct.getPrice());
        }

        return existingProduct;
    }

    public boolean deleteProduct(int id) {
        return products.removeIf(
            product -> product.getProductId() == id);
    }
}