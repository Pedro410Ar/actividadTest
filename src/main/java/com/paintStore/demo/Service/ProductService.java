package com.paintStore.demo.Service;

import com.paintStore.demo.Model.Product;
import com.paintStore.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {


    @Autowired
    ProductRepository productRepository;

    public void createProduct(Product product){
        productRepository.save(product);
    }

    public Product readProductById (Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> readFindAll() {
        return productRepository.findAll();
    }

    public List<Product> readProductByBrand(){
        List<Product> productList = productRepository.findAll();
        List<Product> newList = productList.stream()
                .filter(product -> product.getBrand().equals("Colorin"))
                .collect(Collectors.toList());
        return newList;
    }

    public Product updateProduct (Product product) {
        productRepository.save(product);
        return productRepository.findById(product.getID()).orElse(null);
    }

    public void deleteProduct (Long id) {
        productRepository.deleteById(id);
    }


}
