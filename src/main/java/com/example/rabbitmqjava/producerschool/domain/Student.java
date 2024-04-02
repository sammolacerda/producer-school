package com.example.rabbitmqjava.producerschool.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private boolean male;

}
