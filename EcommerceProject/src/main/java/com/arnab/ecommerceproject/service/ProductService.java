package com.arnab.ecommerceproject.service;

import com.arnab.ecommerceproject.model.Product;
import com.arnab.ecommerceproject.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;
    public List<Product> findAll() {
        return repo.findAll();
    }

    public Product findById(int id) {
        return repo.findById(id).orElse(new Product());
    }

    public void addOrUpdateProduct(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());

        repo.save(product);
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchProducts(keyword);
    }
}
