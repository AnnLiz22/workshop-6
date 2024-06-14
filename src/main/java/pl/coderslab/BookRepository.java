package pl.coderslab;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b from Book b where b.id = ?1")
    Optional<Book> getBookById(Long id);

    @Query("select b from Book b")
    List<Book> findAll();

    @Modifying
    @Query(value = "insert into books (isbn, title, author, publisher, type) values (?, ?, ?, ?, ?)", nativeQuery = true)
    void insert(Book book);

    @Query("delete from Book b where b.id = ?1")
    Optional<Book> removeBookById(Long id);

    @Modifying
    @Query(value = "update books set isbn = ?", nativeQuery = true)
    void update(Book book);
}
