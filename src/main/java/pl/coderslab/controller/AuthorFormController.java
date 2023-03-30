package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.entity.Author;
import pl.coderslab.service.AuthorService;

import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthorFormController {


    private final AuthorService authorService;

    @GetMapping(path="/author/form")
    String showAddAuthorForm(Model model){
        model.addAttribute("author", new Author());
        return "author/add";
    }

    @PostMapping(path="/author/form")
    String processAddAuthor(@Valid Author author, BindingResult errors) {
        if(errors.hasErrors()) {
            return "author/add";
        }
        authorService.save(author);
        return "redirect:/author/list";
    }

    @GetMapping(path = "/author/list")
    String showAuthorList(Model model) {

        List<Author> authors = authorService.findAll();
        model.addAttribute("authors", authors);

        return "author/list";
    }


}
