package com.upc.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BigTreeDto {
    private String username;
    private String email;
    private String name;
    private Date bornAt;
}
