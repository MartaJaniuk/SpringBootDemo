package pl.coderslab.service;

import pl.coderslab.entity.Author;

import java.util.List;

public interface AuthorService {
    public void save(Author author);

    public void update(Author author);

    public Author findById(Long id);

    public List<Author> findAll();

    public void deleteById(Long id);
}
