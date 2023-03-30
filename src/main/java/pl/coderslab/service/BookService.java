package pl.coderslab.service;

import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

import java.util.List;

public interface BookService {

    public void save(Book book);


    public void update(Book book);

    public Book findById(Long id);

    public List<Book> findAll();

    public List<Book> findByRating(int rating);

    public List<Book> findNotEmptyPublisher();

    public List<Book> findByPublisher(Publisher publisher);

    public void deleteById(Long id);

    List<Book> findByTitle(String title);

    List<Book> findByCategory(Category category);

    List<Book> findByCategoryId(Long id);

}
