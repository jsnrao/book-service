package com.word.library.request.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1.0/book")
@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{bookReference}")
    public ResponseEntity<String> retrieveBook(String bookReference) throws BookNotFoundException {
        return ResponseEntity.ok().body(bookService.retrieveBook(bookReference));
    }

    @GetMapping("/book_summary/{bookReference}")
    public ResponseEntity<String>  getBookSummary(String bookReference) throws BookNotFoundException {
        return ResponseEntity.ok().body(bookService.getBookSummary(bookReference));
    }

}
