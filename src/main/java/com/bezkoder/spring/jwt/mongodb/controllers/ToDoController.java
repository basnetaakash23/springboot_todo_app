package com.bezkoder.spring.jwt.mongodb.controllers;

import com.bezkoder.spring.jwt.mongodb.models.ToDo;
import com.bezkoder.spring.jwt.mongodb.payload.response.TodoResponse;
import com.bezkoder.spring.jwt.mongodb.repository.ToDoRepository;
//import com.bezkoder.spring.jwt.mongodb.security.services.TodoService;
import com.bezkoder.spring.jwt.mongodb.services.TodoService;
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

    @Autowired
    private TodoService todoService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/", method = RequestMethod.GET)
    public List<TodoResponse> getAllTodos(){

        //return repository.findAll();

        return todoService.todoResponse();
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
