package pl.coderslab;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    private EntityManager entityManager;


    public void saveBook(Book book){
        entityManager.persist(book);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public Book findById(Long id) {
        TypedQuery<Book> query = entityManager.createQuery("""
                        SELECT b FROM Book b
                        WHERE b.id = :id
                        """, Book.class)
                .setParameter("id", id);
        return query.getSingleResult();
    }

    public void deleteById(Long id) {
        Book book = entityManager.find(Book.class, id);
        if (book != null) {
            entityManager.remove(book);
        }
    }
}
