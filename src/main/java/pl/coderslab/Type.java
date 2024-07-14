package pl.coderslab;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="types")
@ToString
@NoArgsConstructor
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column
    @Enumerated(EnumType.STRING)
    private Type.Name name;

    public Type(Name name) {
        this.name = name;
    }

    public enum Name {
        CRIME_INVESTIGATION,
        FANTASY,
        HORROR,
        NOVEL,
        SCIENCE_FICTION;
    }
}
