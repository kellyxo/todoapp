package com.example.todoapp.service;

import com.example.todoapp.entity.ToDo;
import com.example.todoapp.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService
{
    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> getAllToDos(){
        return  toDoRepository.findAll();
    }
    public ToDo getToDoByID(Long id){
        return toDoRepository.getReferenceById(id);
    }
    public ToDo createToDo(String title, String description,boolean completed ) {
        ToDo toDo = new ToDo(title, description, completed);
        return toDoRepository.save(toDo);
    }
    public ToDo updateToDo(ToDo toDo) {
        if (!toDo.isCompleted() == true)
            toDo.setCompleted(true);

        return toDoRepository.save(toDo);
    }

    public void deleteToDoById(Long id) {
        toDoRepository.deleteById(id);
    }



}
