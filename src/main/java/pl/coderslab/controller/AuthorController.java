package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Author;
import pl.coderslab.service.AuthorService;

import java.util.List;
import java.util.Objects;

@RestController
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    //create author
    @PostMapping(path="/author")
    void save (@RequestParam String firstName, @RequestParam String lastName){
        final Author author = new Author();

        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorService.save(author);
    }


    //edycja
    @PutMapping(path="author/{id}")
    public void update(@PathVariable Long id, @RequestParam String firstName, @RequestParam String lastName){
        Author author = authorService.findById(id);

        if(Objects.nonNull(author)){
            author.setFirstName(firstName);
            author.setLastName(lastName);
            authorService.update(author);
        }
    }

    //get author by id
    @GetMapping(path="/author/{id}", produces = "text/plain;charset=utf-8")
    String findById(@PathVariable Long id){
        final Author author = authorService.findById(id);
        return Objects.nonNull(author) ? author.toString() : "Nie znaleziono autora o podanym id " + id;
    }

    //get all authors
    @GetMapping(path="/authors", produces = "text/plain;charset=utf-8")
    String findAll(){
        final List<Author> authors = authorService.findAll();
        return authors.toString();
    }

    //delete author by id
    @DeleteMapping(path="author/{id}")
    void deleteById(@PathVariable Long id){
        authorService.deleteById(id);
    }


}
