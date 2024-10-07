package com.nimapinfotech.ecommerce.nEcommerce.services;
import com.nimapinfotech.ecommerce.nEcommerce.errorhandler.ResourceNotFoundException;
import com.nimapinfotech.ecommerce.nEcommerce.models.Product;
import com.nimapinfotech.ecommerce.nEcommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }


    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for id: " + id));
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        // Update other fields as necessary
        return productRepository.save(product);
    }

    public void deleteProduct(Long id)
    {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for id: " + id));
        productRepository.delete(product);
    }
}
