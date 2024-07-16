package pl.coderslab;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="types")
@ToString
@NoArgsConstructor
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

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
