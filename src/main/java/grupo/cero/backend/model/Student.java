package grupo.cero.backend.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "STUDENTS")
public class Student {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    @Column(
            name = "STUDENT_ID",
            unique = true,
            nullable = false
    )
    private int idStudent;

    @Column(name = "name")
    private String name;

    @Column(name = "rut")
    private String rut;
}
