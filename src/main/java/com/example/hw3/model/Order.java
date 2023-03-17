package com.example.hw3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    String reference;
    String title;
    double price;
    private Book myBook;
    private int quantity;
    private double amount;

//    public Order(Book myBook){
//        this.myBook = myBook;
//    }

}
