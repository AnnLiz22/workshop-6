package pl.coderslab;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Primary
public class JpaBookService implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> get(Long id) {
       Optional<Book> book = bookRepository.getBookById(id);
       return book;
    }

    @Override
    public void add(Book book) {
        bookRepository.insert(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.removeBookById(id);
    }

    @Override
    public void update(Book book) {
        bookRepository.update(book);
    }
}
