package pl.coderslab;

import javax.validation.constraints.Size;

import lombok.*;
import org.hibernate.validator.constraints.ISBN;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ISBN
    private String isbn;

    @Size(min = 2, max = 50)
    private String title;

    private String author;
    private String publisher;

    @NotNull
    @ManyToOne (cascade = CascadeType.ALL)
    private Type type;

}