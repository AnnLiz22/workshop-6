package pl.coderslab;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface BookService {
    Optional<Book> get(Long id);

    List<Book> getBooks();

    void add(Book book);

    void delete(Long id);

    void update(Book book);

}