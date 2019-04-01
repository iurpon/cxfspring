package ru.trandefil.spring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "tasks")
public class Task extends AbstractEntity {

    @Column(unique = true)
    private String name;

    @Column
    private String description;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date start;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date end;

    @ManyToOne(fetch = FetchType.EAGER)
    private Project project;

    @OneToOne(fetch = FetchType.EAGER)
    private User assignee;

    @OneToOne(fetch = FetchType.EAGER)
    private User executor;

    public Task(String id, String name, String description, Date start, Date end,
                Project project, User assignee, User executor) {
        super(id);
        this.name = name;
        this.description = description;
        this.start = start;
        this.end = end;
        this.project = project;
        this.assignee = assignee;
        this.executor = executor;
    }

}
