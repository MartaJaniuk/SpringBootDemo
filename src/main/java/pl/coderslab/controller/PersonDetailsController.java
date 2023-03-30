package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.PersonDetails;
import pl.coderslab.service.PersonDetailsService;

import java.util.Objects;

@RestController
public class PersonDetailsController {

    private PersonDetailsService personDetailsService;

    public PersonDetailsController(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    //create personDetails
    @PostMapping(path="/person_details")
    void save (@RequestParam String firstName, @RequestParam String lastName, @RequestParam Long streetNumber, @RequestParam String street, @RequestParam String city){
        final PersonDetails personDetails = new PersonDetails();

        personDetails.setFirstName(firstName);
        personDetails.setLastName(lastName);
        personDetails.setStreetNumber(streetNumber);
        personDetails.setCity(city);
        personDetails.setStreet(street);

        personDetailsService.save(personDetails);
    }


    //edycja
    @PutMapping(path="person_details/{id}")
    public void update(@PathVariable Long id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam Long streetNumber, @RequestParam String street, @RequestParam String city) {
        PersonDetails personDetails = personDetailsService.findById(id);

        if(Objects.nonNull(personDetails)){
            personDetails.setFirstName(firstName);
            personDetails.setLastName(lastName);
            personDetails.setStreetNumber(streetNumber);
            personDetails.setCity(city);
            personDetails.setStreet(street);
            personDetailsService.update(personDetails);
        }
    }

    //get personDetails by id
    @GetMapping(path="/person_details/{id}", produces = "text/plain;charset=utf-8")
    String findById(@PathVariable Long id){
        final PersonDetails personDetails = personDetailsService.findById(id);
        return Objects.nonNull(personDetails) ? personDetails.toString() : "Nie znaleziono autora o podanym id " + id;
    }

    //delete personDetails by id
    @DeleteMapping(path="person_details/{id}")
    void deleteById(@PathVariable Long id){personDetailsService.deleteById(id);
    }


}
