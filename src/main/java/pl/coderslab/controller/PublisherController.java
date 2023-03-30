package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.PublisherService;

import java.util.List;
import java.util.Objects;

@RestController
public class PublisherController {

    private PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    //create publisher
    @PostMapping(path="/publisher")
    void save (@RequestParam String name){
        final Publisher publisher = new Publisher();

        publisher.setName(name);

        publisherService.save(publisher);
    }


    //edycja
    @PutMapping(path="publisher/{id}")
    public void update(@PathVariable Long id, @RequestParam String name){
        Publisher publisher = publisherService.findById(id);

        if(Objects.nonNull(publisher)){
            publisher.setName(name);
            publisherService.update(publisher);
        }
    }

    //get publisher by id
    @GetMapping(path="/publisher/{id}", produces = "text/plain;charset=utf-8")
    String findById(@PathVariable Long id){
        final Publisher publisher = publisherService.findById(id);
        return Objects.nonNull(publisher) ? publisher.toString() : "Nie znaleziono wydawcy o podanym id " + id;
    }

    //get all publishers
    @GetMapping(path="/publishers", produces = "text/plain;charset=utf-8")
    String findAll(){
        final List<Publisher> publishers = publisherService.findAll();
        return publishers.toString();
    }

    //delete publisher by id
    @DeleteMapping(path="publisher/{id}")
    void deleteById(@PathVariable Long id){
        publisherService.deleteById(id);
    }
}
