package com.example.restservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class Payload {
    @JsonProperty("key")
    private String eventType;
}
