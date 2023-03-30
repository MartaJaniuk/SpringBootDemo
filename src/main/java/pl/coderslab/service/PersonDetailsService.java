package pl.coderslab.service;

import pl.coderslab.entity.PersonDetails;

public interface PersonDetailsService {

    public void save(PersonDetails personDetails);

    public void update(PersonDetails personDetails);

    public PersonDetails findById(Long id);

    public void deleteById(Long id);
}
