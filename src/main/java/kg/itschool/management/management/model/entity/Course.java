package kg.itschool.management.management.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_course")
@ToString(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course extends BaseEntity {

    @Column(name = "course_name", nullable = false, unique = true, length = 50)
    String courseName;

//    @Column(name = "price", nullable = false, columnDefinition = "MONEY DEFAULT 0")
//    BigDecimal price;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Course course = (Course) o;
        return getId() != null && Objects.equals(getId(), course.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
