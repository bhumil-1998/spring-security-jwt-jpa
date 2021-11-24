package com.example.springsecurityjwtjpa.todo;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "todo")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "todo_id")
    private long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "description")
    private String description;

    @Column(name = "target_date")
    private Date targetDate;

    @Column(name = "is_done")
    private boolean isDone;
}
