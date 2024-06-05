package com.brewed_awakening.product_catalog.controller;

import com.brewed_awakening.product_catalog.dto.ProductItem;
import com.brewed_awakening.product_catalog.repository.ProductItemRepository;
//import com.brewed_awakening.product_catalog.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product-catalog/")
public class ProductCatalogController {
    private final ProductItemRepository productItemRepository;
//    private final S3Service s3Service;

//    @Autowired
//    public ProductCatalogController(ProductItemRepository productItemRepository, S3Service s3Service) {
//        this.productItemRepository = productItemRepository;
//        this.s3Service = s3Service;
//    }
@Autowired
public ProductCatalogController(ProductItemRepository productItemRepository) {
    this.productItemRepository = productItemRepository;

}

    @GetMapping("/product-list")
    public List<ProductItem> getProductList() {
        List<ProductItem> productItems = productItemRepository.findAll();

        return productItems;
    }

//    @PostMapping("/uploadImage/{id}")
//    public ProductItem uploadProductImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
//        try {
//            ProductItem productItem = productItemRepository.findById(id).orElseThrow(() -> new Exception("Product not found"));
//            String imageUrl = s3Service.uploadFile(file);
//            productItem.setImageUrl(imageUrl);
//            return productItemRepository.save(productItem);
//        } catch (Exception e) {
//
//        }
//
//        return null;
//    }

    @PostMapping("/saveItem")
    public ProductItem saveProductItem(@RequestBody ProductItem productItem){
        return productItemRepository.save(productItem);
    }
}
