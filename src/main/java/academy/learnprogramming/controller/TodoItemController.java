package academy.learnprogramming.controller;

import academy.learnprogramming.model.ToDoItem;
import academy.learnprogramming.model.TodoData;
import academy.learnprogramming.service.TodoItemService;
import academy.learnprogramming.util.AttributeNames;
import academy.learnprogramming.util.Mappings;
import academy.learnprogramming.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {

//    fields
    private final TodoItemService todoItemService;

    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    //    model attribute section

    @ModelAttribute
    public TodoData todoData(){
        return todoItemService.getData();
    }

//    handler methods
//    http://localhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items(){
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id, Model model){
        log.info("editing id ={}", id);
        ToDoItem toDoItem = todoItemService.getItem(id);

        if(toDoItem == null){
            toDoItem = new ToDoItem("", "", LocalDate.now());
        }

        model.addAttribute(AttributeNames.TODO_ITEM, toDoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) ToDoItem toDoItem){

        log.info("todoItem from form = {}", toDoItem);
        if(toDoItem.getId() == 0){
            todoItemService.addItem(toDoItem);
        } else{
            todoItemService.updateItem(toDoItem);
        }
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id){
        log.info("Deleting item with id= {}", id);
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model){
        ToDoItem toDoItem = todoItemService.getItem(id);
        model.addAttribute(AttributeNames.TODO_ITEM, toDoItem);
        return ViewNames.VIEW_ITEM;
    }
}
