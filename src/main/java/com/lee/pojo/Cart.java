package com.lee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private int cid;
    private int uid;
    private int pid;
    private double price;
    private int num;
    private double total_price;
}
