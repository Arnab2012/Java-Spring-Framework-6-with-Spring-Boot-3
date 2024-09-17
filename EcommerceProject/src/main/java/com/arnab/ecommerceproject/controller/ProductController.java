package com.arnab.ecommerceproject.controller;

import com.arnab.ecommerceproject.model.Product;
import com.arnab.ecommerceproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService service;
//  method to fetch all Product Details
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return service.findAll();
    }

//  method to Fetch Product by Id
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id){
        Product product=service.findById(id);
        return product;
    }

//  method to addOrUpdate Product with image
    @PostMapping("/product")
    public void addProduct(@RequestPart Product product,@RequestPart MultipartFile imageFile) throws IOException {
        service.addOrUpdateProduct(product,imageFile);
    }

//  method to updateProduct
    @PutMapping("/product/{id}")
    public void updateProduct(@PathVariable int id,@RequestPart Product product,@RequestPart MultipartFile imageFile) throws IOException{
        service.addOrUpdateProduct(product,imageFile);
    }

//  method to get Image Data
    @GetMapping("/product/{productId}/image")
    public byte[] getImage(@PathVariable int productId){
        return service.findById(productId).getImageData();
    }

//  method to delete product
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable int id){
        service.deleteById(id);
    }

//  method to search product
    @GetMapping("/product/search")
    public List<Product> search(@RequestParam String Keyword){
        return service.searchProducts(Keyword);
    }

}


