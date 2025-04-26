package models;



import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "departments2" , schema = "sys")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name="department2_gen", sequenceName="system.departments2_seq", allocationSize = 1)
public class Department2 implements Serializable {

    private static final long serialVersionUID = -8807399920421569680L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="departments2_gen")
    @Column(name = "id")
    private Integer id;

    @Column(name = "NAME")
    private String name;

}
