package com.example.todoapp.controller;

import com.example.todoapp.entity.ToDo;
import com.example.todoapp.entity.ToDoRequest;
import com.example.todoapp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")  // Base path for all endpoints
public class ToDoController {
    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public List<ToDo> getAllToDos() {
        return toDoService.getAllToDos();
    }

    @GetMapping("/{id}")
    public ToDo getToDoById(@PathVariable Long id) {
        return toDoService.getToDoByID(id);  // Ensure method name consistency
    }

    @PostMapping
    public ToDo createToDo(@RequestBody ToDoRequest toDoRequest) {
        return toDoService.createToDo(toDoRequest.getTitle(), toDoRequest.getDescription(), toDoRequest.isCompleted());
    }

    @PutMapping("/{id}")
    public ToDo updateToDo(@PathVariable Long id, @RequestBody ToDo toDo) {
        toDo.setId(id);
        return toDoService.updateToDo(toDo);
    }

    @DeleteMapping("/{id}")
    public void deleteToDoById(@PathVariable Long id) {
        toDoService.deleteToDoById(id);
    }

}
