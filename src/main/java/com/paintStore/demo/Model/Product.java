package com.paintStore.demo.Model;


import jakarta.persistence.Entity;
//import lombok.AllArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    //ATRIBUTOS DEL PRODUCTO PINTURAS
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String Colour;
    private String Brand;
    private Float price;

    //CONSTRUCTORES
    public Product(Long ID, String colour, String brand, Float price) {
        this.ID = ID;
        this.Colour = colour;
        this.Brand = brand;
        this.price = price;
    }

    public Product(String colour, String brand, Float price) {
        Colour = colour;
        Brand = brand;
        this.price = price;
    }
}
