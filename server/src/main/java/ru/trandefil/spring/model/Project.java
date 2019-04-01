package ru.trandefil.spring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "projects")
@ToString(callSuper = true,exclude = {"tasks"})
public class Project extends AbstractEntity {

    @Column(unique = true)
    private String name;

    @Column
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "project",cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

    public Project(String id, String name, String description, User user) {
        super(id);
        this.name = name;
        this.description = description;
        this.user = user;
    }

}
