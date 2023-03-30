package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;
import pl.coderslab.service.CategoryService;
import pl.coderslab.service.PublisherService;

import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookFormController {

    private final BookService bookService;
    private final PublisherService publisherService;
    private final CategoryService categoryService;
    private final AuthorService authorService;

    @GetMapping(path="/book/form")
    String showAddBookForm(Model model){
        model.addAttribute("book", new Book());
        return "book/add";
    }

    @PostMapping(path="/book/form")
    String processAddBook(@Valid Book book, BindingResult errors){
        if(errors.hasErrors()) {
            return "book/add";
        }

        bookService.save(book);
        //  return "book/success";
        return "redirect:/book/list";
    }


    @GetMapping(path="/book/edit")
    String showEditBookForm(@RequestParam long id, Model model){

        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book/edit";
    }


    @PostMapping(path="/book/edit")
    String processEditBookForm(@Valid Book book, BindingResult errors){
        if(errors.hasErrors()) {
            return "book/edit";
        }

        bookService.update(book);
        return "redirect:/book/list";
    }



    @GetMapping(path = "/book/list")
    String showBookList(Model model) {

        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);

        return "book/list";
    }

    //http://localhost:8080/book/search?title=Java+techniki+kodowania
    @GetMapping(path="/book/search")
    String findByTitle(@RequestParam String title, Model model) {
        List<Book> books = bookService.findByTitle(title);
        model.addAttribute("books",books);
        return "book/list";
    }

    //http://localhost:8080/book/search?id=2
    //nie ma request param, bo bindowanie i automatycznie zrobi set id na obiekcie category
    //dodanie params id sprawi, że url z końcówką search?id=coś trafi tu nie do ogólnego search powyżej
    @GetMapping(path="/book/search", params = "id")
    String findByCategory(Category category, Model model) {
        List<Book> books = bookService.findByCategory(category);
        model.addAttribute("books",books);

        return "book/list";
    }


    //http://localhost:8080/book/search?categoryId=2
    //jest request param, bo Category nie ma pola categoryId, więc musi być @RequestParam

    //inne rozwiązanie mogłoby być
    //@GetMapping(path="/book/search/categoryId")
    @GetMapping(path="/book/search", params = "categoryId")
    String findByCategoryId(@RequestParam Long categoryId, Model model) {
        List<Book> books = bookService.findByCategoryId(categoryId);
        model.addAttribute("books",books);

        return "book/list";
    }

    @ModelAttribute("publishers")
    List<Publisher> publishers(){
        return publisherService.findAll();
    }

    @ModelAttribute("categories")
    List<Category> categories(){
        return categoryService.findAll();
    }

    @ModelAttribute("authors")
    List<Author> authors(){
        return authorService.findAll();
    }




}
