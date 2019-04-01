package ru.trandefil.spring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.trandefil.spring.util.UUIDUtil;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public abstract class AbstractEntity {

    @Id
    protected String id = UUIDUtil.getUniqueString();

    public AbstractEntity(String id) {
        this.id = id;
    }

    public boolean isNew() {
        return id == null;
    }

}
