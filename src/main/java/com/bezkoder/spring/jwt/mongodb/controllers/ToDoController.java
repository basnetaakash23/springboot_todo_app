package com.bezkoder.spring.jwt.mongodb.controllers;

import com.bezkoder.spring.jwt.mongodb.models.ToDo;
import com.bezkoder.spring.jwt.mongodb.models.User;
import com.bezkoder.spring.jwt.mongodb.repository.ToDoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "http://localhost:3000")
public class ToDoController {

    @Autowired
    private ToDoRepository repository;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/", method = RequestMethod.GET)
    public List<ToDo> getAllTodos(){
        return repository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/todo", method = RequestMethod.GET)
    public List<ToDo> getAllTodosForUser(@RequestParam("userName") String userName){
        return repository.findByUserName(userName);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/search_todo", method = RequestMethod.GET)
    public List<ToDo> getAllTodosByText(@RequestParam("text") String text){
        Sort sort = Sort.by(text);
        TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(text);
        List<ToDo> result = repository.findAllBy(criteria, sort);
        System.out.println(result.toString());
        return result;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/", method = RequestMethod.POST)
    public ToDo createTodo(@Valid @RequestBody ToDo todo){
        todo.set_id(ObjectId.get());
        repository.save(todo);
        return todo;

    }

}
