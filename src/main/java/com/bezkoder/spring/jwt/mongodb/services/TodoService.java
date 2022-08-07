package com.bezkoder.spring.jwt.mongodb.services;

import com.bezkoder.spring.jwt.mongodb.payload.response.TodoResponse;

import java.util.List;

public interface TodoService {

    List<TodoResponse> todoResponse();
}
