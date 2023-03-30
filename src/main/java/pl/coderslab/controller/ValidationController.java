package pl.coderslab.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Book;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.Set;

@Controller
@Slf4j //inna możliwość do loggera
public class ValidationController {

    private final Validator validator;
    public ValidationController(Validator validator) {
        this.validator = validator;
    }
    @RequestMapping("/validate")

    public String validateTest(Model model) {
        Book p2 = new Book();
        p2.setTitle("ala");
        Set<ConstraintViolation<Book>> violations = validator.validate(p2);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Book> constraintViolation : violations) {
                log.error(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage()); }
            model.addAttribute("violations", violations);
            return "book/validation";


        } else {
            // save object
        }
        return "validateResult";
    }
}
