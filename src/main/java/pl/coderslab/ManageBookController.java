package pl.coderslab;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/admin/books")
@RequiredArgsConstructor
public class ManageBookController {

    private final JpaBookService jpaBookService;
    private final MockBookService mockBookService;

    @GetMapping
    public String showPosts(Model model) {
        List<Book> books = jpaBookService.getBooks();
        model.addAttribute("book", new Book());
        return "bookList";
    }

    @GetMapping("/form")
    public String showBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "bookForm";
    }

    @PostMapping("/form/add")
    public String processBookForm(@ModelAttribute @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "bookForm";
        }
        if (book.getId() == null) {
            jpaBookService.add(book);
            log.info("Saved {}", book);
        } else {
            jpaBookService.update(book);
            log.info("Updated {}", book);
        }
        return "redirect:/admin/books/all";
    }

    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model){
        Optional<Book> book = jpaBookService.get(id);
        model.addAttribute("book", book);
        return "bookForm";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        jpaBookService.delete(id);
        log.info("Deleted book with id {}", id);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/all")
    public String showAllBooks(){
        return "bookList";
    }

    @ModelAttribute("books")
    public List<Book> getAllBooks(){
        return jpaBookService.getBooks();
    }

}
