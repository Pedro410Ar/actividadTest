package com.paintStore.demo.Model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private static Product product;

    @Test
    public void setAndGetBrandTest(){
        String testBrand = "Colorin";
        product.setBrand(testBrand);
        System.out.println("Probando el test de Brand. La marca pedida es Colorin. Se obtiene: " + testBrand);
        Assertions.assertEquals(product.getBrand(),testBrand);
    }

    @Test
    public void setAndGetColourTest(){
        String testColour = "Red";
        product.setColour(testColour);
        System.out.println("Probando el test de Colour. El color pedido es Red. Se obtiene: " + testColour);
        Assertions.assertEquals(product.getColour(),testColour);
    }
    @Test
    public void testId1 (){
        Long testId = 1L;
        product.setID(testId);
        System.out.println("Probando el ID. El ID pedido es 53. Se obtiene: " + testId);
        Assertions.assertEquals(product.getID(), testId);
    }

    @BeforeAll
    public static void setUp(){
        System.out.println("Probando el test de creacion");
        product = new Product();
    }
}