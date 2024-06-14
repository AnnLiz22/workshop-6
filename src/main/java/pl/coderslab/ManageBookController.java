package pl.coderslab;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/admin/books")
@RequiredArgsConstructor
public class ManageBookController {

    private final JpaBookService jpaBookService;

    @GetMapping
    public String showPosts(Model model) {
        List<Book> books = jpaBookService.getBooks();
        model.addAttribute("books", books);
        return "bookList";
    }

}
