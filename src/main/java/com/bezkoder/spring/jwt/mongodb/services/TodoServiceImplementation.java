package com.bezkoder.spring.jwt.mongodb.services;

import com.bezkoder.spring.jwt.mongodb.models.ToDo;
import com.bezkoder.spring.jwt.mongodb.payload.response.TodoResponse;
import com.bezkoder.spring.jwt.mongodb.repository.ToDoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TodoServiceImplementation implements TodoService{
    ObjectMapper objMapper = new ObjectMapper();

    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public List<TodoResponse> todoResponse() {
        List<ToDo> allTodos = toDoRepository.findAll();
        System.out.println(allTodos);
        List<TodoResponse> todoResponses = allTodos.stream().map(maptoToDoDto).collect(Collectors.toList());
        return todoResponses;
    }

    private Function<ToDo, TodoResponse> maptoToDoDto = p ->
            TodoResponse.builder().userName(p.getUserId()).
            todo(p.getText()).
                    status(p.getStatus()).build();
}
