package academy.learnprogramming.service;
import academy.learnprogramming.model.ToDoItem;
import academy.learnprogramming.model.TodoData;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService{

//    fields
    @Getter
    private TodoData data = new TodoData();

//    public methods

    @Override
    public void addItem(ToDoItem toAdd) {
        data.addItem(toAdd);
    }

    @Override
    public void removeItem(int id) {
        data.removeItem(id);
    }

    @Override
    public ToDoItem getItem(int id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(ToDoItem toUpdate) {
        data.updateItem(toUpdate);
    }

}
