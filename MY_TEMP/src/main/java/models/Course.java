package models;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "courses" , schema = "sys")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name="courses_gen", sequenceName="system.courses_seq", allocationSize = 1)
public class Course implements Serializable {

    private static final long serialVersionUID = -3645824407886675908L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="courses_gen")
    @Column(name = "id")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "STUDENTS_COURSES",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")}
    )
    private List<Student> students;

}
