package pl.coderslab;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/admin/books")
@RequiredArgsConstructor
public class ManageBookController {

    private final JpaBookService jpaBookService;
    private final TypeRepository typeRepository;

    @GetMapping
    public String showPosts(Model model) {
        model.addAttribute("books", jpaBookService.getBooks());
        model.addAttribute("book", new Book());
        return "bookList";
    }

    @GetMapping("/book/{id}")
    public String showBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", jpaBookService.get(id).orElseThrow(EntityNotFoundException::new));
        return "book";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String showBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("type", typeRepository.findAll());
        return "bookForm";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String processBookForm(@Valid Book book, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "bookForm";
        }

        jpaBookService.save(book);
       // log.info("Saved {}", book);

        return "redirect:/admin/books/all";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditBook(@PathVariable Long id, Model model) {
        Optional<Book> book = jpaBookService.get(id);
        book.ifPresent(value -> model.addAttribute("book", value));
        return "bookForm";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editBook(@Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "bookForm";
        }
        jpaBookService.save(book);
       // log.info("Book {} updated", book);
        return "redirect:/admin/books/all";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        jpaBookService.delete(id);
      //  log.info("Deleted book with id {}", id);

        return "redirect:/admin/books/all";
    }

    @GetMapping("/all")
    public String showAllBooks() {
        return "bookList";
    }

    @ModelAttribute("books")
    public List<Book> getAllBooks() {
        return jpaBookService.getBooks();
    }

    @ModelAttribute("types")
    public List<Type> getBookTypes() {
        return this.typeRepository.findAll();
    }

}
