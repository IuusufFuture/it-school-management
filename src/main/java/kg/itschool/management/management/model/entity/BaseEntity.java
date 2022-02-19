package kg.itschool.management.management.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
abstract class BaseEntity extends AbstractPersistable<Long> {

    @CreationTimestamp
    Date dateCreated;

    @UpdateTimestamp
    Date dateUpdated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BaseEntity that = (BaseEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
