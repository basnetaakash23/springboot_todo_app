package com.bezkoder.spring.jwt.mongodb.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class TodoResponse {

    private String userName;
    private String todo;
    private String status;
}
