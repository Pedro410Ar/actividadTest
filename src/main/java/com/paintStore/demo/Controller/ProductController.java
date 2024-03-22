package com.paintStore.demo.Controller;

import com.paintStore.demo.Model.Product;
import com.paintStore.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/create")
    public void createProduct (@RequestBody Product product){
        productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public Product readProduct (@PathVariable Long id){
        return productService.readProductById(id);
    }

    @GetMapping(" ")
    public List<Product> readPlayer() {
        return productService.readFindAll();
    }

    @GetMapping("/brand")
    public List<Product> getBrand( ){
        return productService.readProductByBrand();
    }

    @PutMapping("/update")
    public Product updateProduct (@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete{id}")
    public void deleteProduct (@PathVariable Long id){
        productService.deleteProduct(id);

    }


}
