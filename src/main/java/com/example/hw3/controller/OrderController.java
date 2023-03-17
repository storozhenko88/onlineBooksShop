package com.example.hw3.controller;

import com.example.hw3.model.Book;
import com.example.hw3.model.Order;
import com.example.hw3.service.BookService;
import com.example.hw3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bookstore/cart")
public class OrderController {
    private final OrderService orderService;
    private final BookService service;
    private List<Order> orders = new ArrayList<>();

    @Autowired
    public OrderController(OrderService orderService, BookService service) {
        this.orderService = orderService;
        this.service = service;
    }

    @PostMapping("/save")
    public String add(@ModelAttribute("book") Book book, Model model) {
        model.addAttribute("orders", orderService.add(book));
        return "yourCart";
    }

    @PostMapping("/save/update")
    public String update(@ModelAttribute("order") Order order, Model model) {
        if (orderService.update(order).isEmpty()) {
            model.addAttribute("books", service.getAllBooks());
            return "allBooks";
        } else {
            model.addAttribute("orders", orderService.getOrders());
            return "yourCart";
        }
    }

    @PostMapping("/order")
    public String showOrder(Model model) {
            model.addAttribute("orders", orderService.getOrders());
            return "yourOrder";
        }
}
