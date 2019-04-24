package ru.trandefil.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.trandefil.spring.util.UUIDUtil;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public abstract class AbstractEntity  implements Serializable {

    @Id
    protected String id = UUIDUtil.getUniqueString();

    public AbstractEntity(String id) {
        this.id = id;
    }


    @JsonIgnore
    public boolean isNew() {
        return id == null;
    }

}
