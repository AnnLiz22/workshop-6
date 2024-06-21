package pl.coderslab;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b from Book b where b.id = ?1")
    Optional<Book> getBookById(Long id);

    @Query("select b from Book b")
    List<Book> findAll();

    @Modifying
    @Transactional
    @Query(value = "insert into books (isbn, title, author, publisher, type_id) values (:isbn, :title, :author, :publisher, :typeId)", nativeQuery = true)
    void insert(@Param("isbn") String isbn,
                @Param("title") String title,
                @Param("author") String author,
                @Param("publisher") String publisher,
                @Param("typeId") Long typeId);

    @Query("delete from Book b where b.id = ?1")
    Optional<Book> removeBookById(Long id);

    @Modifying
    @Query(value = "update books set isbn = :isbn, title = :title, author = :author, publisher = :publisher, type_id = :typeId where id = :id", nativeQuery = true)
    void update(@Param("isbn") String isbn,
                @Param("title") String title,
                @Param("author") String author,
                @Param("publisher") String publisher,
                @Param("typeId") Long typeId,
                @Param("id") Long id);
}
