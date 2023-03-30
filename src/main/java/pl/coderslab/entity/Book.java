package pl.coderslab.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@ToString(exclude="authors")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=5, message = "{title.to.short.error}") //zdefiniowany w ValidationMessages
    @NotBlank(message="{title.not.empty.error}")
    private String title;

    @Range(min=1, max=10)
    private int rating;

    @Size(max=600)
    private String description;


    @ManyToOne (fetch = FetchType.LAZY)
    @NotNull
    private Publisher publisher;


    @ManyToMany
    @JoinTable(name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    @NotEmpty
    private List<Author> authors = new ArrayList<>();

    @Min(1)
    private int pages;

    @ManyToOne (fetch = FetchType.LAZY) // standardowo jest eager
    @NotNull
    private Category category;

}