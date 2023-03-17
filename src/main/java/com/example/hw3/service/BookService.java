package com.example.hw3.service;

import com.example.hw3.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> availableBooks;
    public BookService() {
        availableBooks = new ArrayList<>() {
            {
                add(new Book("https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9780/7515/9780751565355.jpg", "Animals Quiz Book", 7.18));
                add(new Book("https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9780/7603/9780760363546.jpg", "Top Gun", 23.37));
                add(new Book("https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9780/2416/9780241621264.jpg", "DK Eyewitness Top 10 San Francisco", 6.62));
                add(new Book("https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9780/2611/9780261102217.jpg", "Hobbit 75th Anniversary", 10.05));

            }
        };

    }


    public List<Book> getAllBooks (){
        return availableBooks;
    }


}
