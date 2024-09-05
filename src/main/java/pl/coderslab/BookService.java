package pl.coderslab;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface BookService {
    Optional<Book> get(Long id);

    List<Book> getBooks();

    Book save(Book book);

    void delete(Long id);

}