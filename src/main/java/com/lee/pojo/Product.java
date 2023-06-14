package com.lee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int pid;
    private String pname;
    private String type;
    private int inventory;
    private double price;
    private String pstate;
    private String image;
    private String profile;
    private String tip;
}
