package com.bezkoder.spring.jwt.mongodb.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "ToDo")
public class ToDo {
    @Id
    public ObjectId _id;

    public String userName;
    private String text;
    private String status;


    public ToDo(){}

    public ToDo(ObjectId _id, String text, String status, String userName){
        this._id = _id;
        this.userName = userName;
        this.text = text;
        this.status = status;
    }

    public String get_id(){
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public void setUserId(String userName){
        this.userName = userName;
    }

    public String getUserId(){
        return this.userName;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText(){
        return this.text;
    }

    public void setStatus(String status){
        this.status = status;

    }

    public String getStatus(){
        return this.status;

    }


}
