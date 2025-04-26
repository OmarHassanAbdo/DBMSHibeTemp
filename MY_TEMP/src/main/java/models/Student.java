package models;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Students")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "id_gen" , sequenceName = "students_seq" , allocationSize = 1)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "id_gen")
    @Column(name = "ID")
    Integer id;
    @Column(name = "NAME")
    String name;
    @Column(name = "AGE")
    Integer age;
    @Column(name = "ADDRESS")
    String adress;
    @Column(name = "JOINED_DATE")
    Date joined_date;
    @Column(name = "dep_id")
    Integer dep_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dep_id" , insertable = false, updatable = false)
    Department2 department;
}

