package pl.coderslab.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {


    //nadpisujemy, żeby w pobieraniu książek pobierało nam publisherów i autorów
    @Override
    @EntityGraph(attributePaths = {"publisher", "authors", "category"}) //wygenruje automatycznie złączenie
    //@Query("select distinct b from Book b left join fetch b.publisher left join fetch b.authors")
    List<Book> findAll();

    @Override

    @EntityGraph(attributePaths = {"publisher", "authors", "category"}) //wygenruje automatycznie złączenie, do edycji
    //@Query("select distinct b from Book b left join fetch b.publisher left join fetch b.authors")
    ////dla sposobu z Query trzeba dodać @Param ("id"), dla @EntityGraph wystarczy (Long id)
    //Optional<Book> findById(@Param ("id") Long id);
    Optional<Book> findById(Long id);

    @EntityGraph(attributePaths = {"publisher", "authors", "category"})
    List<Book> findByTitle(String title); //zamiast tego 2 poniższe
//    @Query("select b from Book b where b.title = :title")
//    List<Book> findByTitle(@Param("title") String title);

    @EntityGraph(attributePaths = {"publisher", "authors", "category"})
    List<Book> findByCategory(Category category); //zamiast tego 2 poniższe (metoda i nad nią zapytanie
//    @Query("select b from Book b where b.category = :category")
//    List<Book> findByCategory(@Param("category") Category category);

    @EntityGraph(attributePaths = {"publisher", "authors", "category"})
    List<Book> findByCategoryId(Long id);


}
