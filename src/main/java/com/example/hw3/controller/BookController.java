package com.example.hw3.controller;


import com.example.hw3.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookstore")
public class BookController {

    private final BookService service;

    @Autowired
    BookController(BookService service, BookService service1){
        this.service = service1;
    }


    @GetMapping("")
    public String showAvailableBooks (Model model){
        model.addAttribute("books", service.getAllBooks());
        return "allBooks";

    }


}
