package pl.coderslab.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.PersonDetails;
import pl.coderslab.repository.PersonDetailsRepository;
import pl.coderslab.service.PersonDetailsService;



@Service
@Transactional
@RequiredArgsConstructor
public class PersonDetailsServiceImpl implements PersonDetailsService {


    private final PersonDetailsRepository personDetailsRepository;


    @Override
    public void save(PersonDetails personDetails) {
        personDetailsRepository.save(personDetails);
    }

    @Override
    public void update(PersonDetails personDetails) {
        personDetailsRepository.save(personDetails);
    }

    @Override
    public PersonDetails findById(Long id) {
        return personDetailsRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        personDetailsRepository.deleteById(id);
    }


//    @Override
//    public List<Book> findByTitle(String title) {
//        return null;
//    }
}
