package pl.coderslab;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class JpaBookServiceTest {
    private JpaBookService jpaBookService;
    private BookRepository bookRepository;


    @BeforeEach
    public void setUp() {
        bookRepository = Mockito.mock(BookRepository.class);
        jpaBookService = new JpaBookService(bookRepository);
    }

    @Test
    void shouldGetAllBooks() {
        Book book1 = new Book();
        Book book2 = new Book();
        book1.setTitle("It");
        book2.setTitle("Misery");
        book1.setAuthor("Stephen King");
        book2.setAuthor("Stephen King");
        List<Book> books = List.of(book1, book2);
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> result = jpaBookService.getBooks();
        Assertions.assertThat(result)
                .contains(book1)
                .contains(book2);
    }

    @Test
    void shouldGetEmptyBookList(){
        when(bookRepository.findAll()).thenReturn(new ArrayList<>());
        List <Book> books = jpaBookService.getBooks();
        Assertions.assertThat(books).isEmpty();
    }

    @Test
    void shouldSaveGivenBook() {
        Book book = new Book();
        book.setTitle("My book");
        book.setAuthor("Stephen King");
        when(bookRepository.save(book)).thenReturn(book);

        Book result = jpaBookService.save(book);

        assertNotNull(jpaBookService.save(book));
        assertEquals(book.getAuthor(), result.getAuthor());
    }
}