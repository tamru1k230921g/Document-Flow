package com.example.documentFlow.core.base;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof BaseEntity entity) || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;

        return getId().equals(entity.getId());
    }

    @Override
    public int hashCode() {
        var tempId = -1;

        if (Objects.nonNull(this.id)) {
            tempId = this.id.intValue();
        }

        return tempId * 5;
    }

}
