package com.study.persentation;

import com.study.domain.Book;
import com.study.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService service;
    private final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    public BookController(BookService service){
        this.service = service;
    }

    @GetMapping
    Collection<Book> readList(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    Book read(@PathVariable Integer id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Book create(@RequestBody Book book){
        Book newBook = service.create(book);
        log.info("book created : {}", newBook);
        return book;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@PathVariable Integer id, @RequestBody Book book){
        book.setId(id);
        service.update(book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Integer id){
        service.delete(id);
    }
}