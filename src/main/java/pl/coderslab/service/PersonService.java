package pl.coderslab.service;

import pl.coderslab.entity.Person;

public interface PersonService {

    public void save(Person person);

    public void update(Person person);

    public Person findById(Long id);

    public void deleteById(Long id);

}
