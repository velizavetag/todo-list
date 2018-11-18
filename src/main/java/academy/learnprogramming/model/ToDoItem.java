package academy.learnprogramming.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
public class ToDoItem {

//    fields

    private int id;
    private String title;
    private String details;
    private LocalDate deadline;

//    constructor
    public ToDoItem(String title, String details, LocalDate deadLine) {
        this.title = title;
        this.details = details;
        this.deadline = deadLine;
    }

}
