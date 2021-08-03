package app.web.pavelk.database7.controller;


import app.web.pavelk.database7.repo.BookRepo;
import app.web.pavelk.database7.shema.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final BookRepo bookRepo;

    @Value("classpath:static/favicon.ico")
    Resource resource;

    @GetMapping("/")
    public String main() {
        return bookRepo.findAll().toString();
    }

    @GetMapping("/s")
    public String main2() {
        bookRepo.save(Book.builder().build());
        return "ok";
    }

    @GetMapping("/{id}")
    public String main3(@PathVariable("id") Long id) {
        return bookRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)).toString();
    }

    @GetMapping("favicon.ico")
    @ResponseBody
    public byte[] returnNoFavicon() throws IOException {
        return resource.getInputStream().readAllBytes();
    }

}
