package com.paintStore.demo.repository;

import com.paintStore.demo.Model.Product;
import com.paintStore.demo.Repository.ProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;


    //@Autowired
    private Product product;

    @BeforeEach
    void setup(){
        product = new Product("White_light", "Alba", 78F);
    }


    @Test
    void createProductTest(){
        //CONFIGURACION PREVIA EN EL SETUP

        //LLAMAR LA FUNCIONALIDAD
        Product productDB = productRepository.save(product);

        //VERIFICAR SALIDA O COMPORTAMIENTO
        assertThat(productDB).isNotNull();
        assertThat(productDB.getID()).isGreaterThan(0);

    }


    @Test
    void readProductByIdTest(){
        //CONFIGURACION PREVIA
        productRepository.save(product);
        //LLAMAR A LA FUNCIONALIDAD
        Product productBD = productRepository.findById(product.getID()).get();
        // verificar la salida o el comportamiento
        assertThat(productBD).isNotNull();
    }


    @Test
    void readProductByBrandTest(){
        //CONFIGURACION PREVIA
        Product product4 = new Product("Pink", "Alba", 105F);
        Product product5 = new Product("Yellow", "Alba", 88F);

        productRepository.save(product4);
        productRepository.save(product5);

        //LLAMAR A LA FUNCIONALIDAD
        List<Product> productList = productRepository.findAll( );
        //Product productBD = productRepository.findAll(product.getBrand()).get();

        // verificar la salida o el comportamiento

        assertThat(productList).isNotNull();
        assertThat(productList).isEqualTo("Alba");
    }




    @Test
    void readFindAllTest (){

        //CONFIGURACION PREVIA
        Product product2 = new Product("Brown", "Colorin", 105F);
        Product product3 = new Product("Rose", "Alba", 88F);
        productRepository.save(product2);
        productRepository.save(product3);

        //LLAMAR A LA FUNCIONALIDAD
        List<Product>productList = productRepository.findAll();

        // verificar la salida o el comportamiento
        assertThat(productList).isNotNull();
        assertThat(productList.size()).isEqualTo(7);
    }


    @Test
    void updateProductTest(){
        //CONFIGURACION PREVIA
        productRepository.save(product);

        //LLAMAR A LA FUNCIONALIDAD
        Product productBD = productRepository.findById(product.getID()).get();
        productBD.setColour ("White_Violet");

        // verificar la salida o el comportamiento
        Product productUpdated = productRepository.save(productBD);
        assertThat(productUpdated.getColour()).isEqualTo("White_Light");
    }




    @Test
    void deleteProductTest(){
        //CONFIGURACION PREVIA
        productRepository.save(product);

        //LLAMAR A LA FUNCIONALIDAD
        productRepository.deleteById(product.getID());

        // verificar la salida o el comportamiento
        Optional<Product> deleteProduct =  productRepository.findById(product.getID());
        assertThat(deleteProduct).isEmpty();
    }


}


