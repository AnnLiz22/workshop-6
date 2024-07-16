package pl.coderslab;

import javax.validation.constraints.Min;

import lombok.*;
import org.hibernate.validator.constraints.ISBN;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@Table(name = "books")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ISBN
    private String isbn;

    @NotNull
    @Size(min=2, max = 50)
    private String title;

    @NotNull
    private String author;
    private String publisher;

    @ManyToOne (cascade = CascadeType.ALL)
    private Type type;

}