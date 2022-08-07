package com.bezkoder.spring.jwt.mongodb.models;


class ToDoDetails {
    private String text;
    private String status;

    public ToDoDetails(String text, String status){
        this.text = text;
        this.status = status;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getText(){
        return this.text;
    }

    public String getStatus(){
        return this.status;
    }
}
