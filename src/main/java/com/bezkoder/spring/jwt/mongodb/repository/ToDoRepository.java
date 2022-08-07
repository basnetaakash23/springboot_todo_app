package com.bezkoder.spring.jwt.mongodb.repository;

import com.bezkoder.spring.jwt.mongodb.models.ToDo;
import com.bezkoder.spring.jwt.mongodb.models.User;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ToDoRepository extends MongoRepository<ToDo, String> {
    ToDo findBy_id(ObjectId _id);


    List<ToDo> findByUserName(String userName);

    @Query("{'text' : ?0}")
    List<ToDo> findByText(String text);

    List<ToDo> findAllBy(TextCriteria criteria, Sort sort);
}


