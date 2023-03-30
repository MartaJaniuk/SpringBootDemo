package pl.coderslab.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;
import pl.coderslab.repository.PersonRepository;
import pl.coderslab.service.PersonDetailsService;
import pl.coderslab.service.PersonService;


@Service
@Transactional
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonDetailsService personDetailsService;


    @Override
    public void save(Person person) {

        PersonDetails personDetails = new PersonDetails();
        personDetails.setStreet("Leśna");
        personDetails.setCity("Warszawa");
        personDetails.setFirstName("Jan");
        personDetails.setLastName("Kowalski");
        personDetails.setStreetNumber(8L);
      //  personDetails.setPerson(person);

        personDetailsService.save(personDetails);

        person.setPersonDetails(personDetails);
        personRepository.save(person);
    }

    @Override
    public void update(Person person) {
        personRepository.save(person);
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

}
