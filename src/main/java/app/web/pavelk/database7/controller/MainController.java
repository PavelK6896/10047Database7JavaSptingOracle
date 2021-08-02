package app.web.pavelk.database7.controller;


import app.web.pavelk.database7.repo.BookRepo;
import app.web.pavelk.database7.shema.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final BookRepo bookRepo;

    @GetMapping("/")
    @ResponseBody
    public String main() {
        return bookRepo.findAll().toString();
    }

    @GetMapping("/s")
    @ResponseBody
    public String main2() {
        bookRepo.save(Book.builder().build());
        return "ok";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String main3(@PathVariable("id") Long id) {
        return bookRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)).toString();
    }

}
