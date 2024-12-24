package com.example.saleCampaign.Controller;

import com.example.saleCampaign.Model.Product;
import com.example.saleCampaign.Model.ResponseDTO;
import com.example.saleCampaign.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("saveProduct")
    public ResponseDTO<Product> saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("getAllProducts")
    public ResponseDTO<List<Product>> saveProduct() {
        return productService.getProductList();
    }

    @GetMapping("getAllPaginated")
<<<<<<< HEAD
    public ResponseDTO<Page<Product>> getAllProductsPaginated(@RequestParam(value = "page")int page,
                                                                 @RequestParam(value = "size") int size) {
=======
    public ResponseDTO<Page<Product>> getAllProductsPaginated(@RequestParam(defaultValue = "1") int page,
                                                                 @RequestParam(defaultValue = "10") int size) {
>>>>>>> 76a03b7672949f5d75ac108297a83e9a5269b12e
        return productService.getAllPaginated(page, size);
    }

    @PostMapping("saveAll")
    public ResponseDTO<List<Product>> saveAll(@RequestBody List<Product> products) {
        return productService.saveAllProduct(products);
    }

    @PutMapping("updatePrice")
    public ResponseDTO<Product> updateProductPrice(@RequestHeader("productId") int productId, @RequestHeader("price") double price) {
        return productService.updateProductPrice(productId, price);
    }


}
