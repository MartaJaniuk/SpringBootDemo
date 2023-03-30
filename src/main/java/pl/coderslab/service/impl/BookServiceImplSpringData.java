package pl.coderslab.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Primary
public class BookServiceImplSpringData implements BookService {

    private final BookRepository bookRepository;
    private final PublisherService publisherService;
    private final AuthorService authorService;


    @Override
    public void save(Book book) {

        bookRepository.save(book);
    }


    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findById(Long id) {

        return bookRepository.findById(id).get();   //get na końcu, bo optional zwracany
    }

    @Override
    public List<Book> findAll(){

        return bookRepository.findAll();
    }

    @Override
    public List<Book> findByRating(int rating) {
        return  null;
        //bookDao.findByRating(rating);
    }

    @Override
    public List<Book> findNotEmptyPublisher(){
        return  null;
                //bookDao.findNotEmptyPublisher();
    }

    @Override
    public List<Book> findByPublisher(Publisher publisher){
        return null;
                //bookDao.findByPublisher(publisher);
    }
    @Override
    public void deleteById(Long id) {

        //bookDao.deleteById(id);
    }

    @Override
    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> findByCategory(Category category) {
        return bookRepository.findByCategory(category);
    }

    @Override
    public List<Book> findByCategoryId(Long id) {
        return bookRepository.findByCategoryId(id);
    }

}
