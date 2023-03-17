package com.example.hw3.service;

import com.example.hw3.model.Book;
import com.example.hw3.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final List<Order> orders;

    public OrderService(List<Order> orders) {
        this.orders = orders;
    }


    public List<Order> add(Book book) {
        for (Order or : orders) {
            if (or.getTitle().equals(book.getTitle())) {
                or.setQuantity(or.getQuantity() + 1);
                or.setAmount(book.getPrice() * or.getQuantity());
                return orders;
            }
        }

        Order order = new Order();
        order.setReference(book.getReference());
        order.setTitle(book.getTitle());
        order.setPrice(book.getPrice());
        order.setQuantity(1);
        order.setAmount(book.getPrice());

        orders.add(order);

        return orders;
    }

    public List<Order> update(Order order) {
        for (Order or : orders) {
            if (or.getTitle().equals(order.getTitle())) {
                if (order.getQuantity() == 0) {
                    orders.remove(or);
                    break;
                } else {
                    or.setQuantity(order.getQuantity());
                    or.setAmount(or.getPrice() * or.getQuantity());
                }

            }
        }
        return orders;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
