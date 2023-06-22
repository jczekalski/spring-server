package com.example.springdemo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@JsonSerialize
@Data
public class Subject {
    @JsonProperty("Id")
    private Integer id;

    @JsonProperty("Nazwa")
    private String name;

    @JsonProperty("ECTS")
    private Integer ects;

    @JsonProperty("Sala")
    private Integer classroom;

    @JsonProperty("Egzamin")
    private Boolean exam;
}
