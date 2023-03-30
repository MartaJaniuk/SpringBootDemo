package pl.coderslab.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Author;
import pl.coderslab.repository.AuthorRepository;
import pl.coderslab.service.AuthorService;


import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;


    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void update(Author author) {
        authorRepository.save(author);
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public List<Author> findAll(){
        return authorRepository.findAll();
    }
    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

}
