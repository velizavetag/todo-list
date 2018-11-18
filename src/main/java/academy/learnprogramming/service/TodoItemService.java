package academy.learnprogramming.service;

import academy.learnprogramming.model.ToDoItem;
import academy.learnprogramming.model.TodoData;

public interface TodoItemService {

    void addItem(ToDoItem toAdd);

    void removeItem(int id);

    ToDoItem getItem(int id);

    void updateItem(ToDoItem toUpdate);

    TodoData getData();


}
