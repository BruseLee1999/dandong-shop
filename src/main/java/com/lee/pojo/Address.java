package com.lee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private int aid;
    private int uid;
    private String name;
    private String mobile;
    private String type;
    private String address;
}
