package com.example.springdemo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@JsonSerialize
@Data
public class Activity {
    private Integer id;

//    @JsonProperty("nazwa")
    private String name;

//    @JsonProperty("priorytet")
    private Integer priority;
}
