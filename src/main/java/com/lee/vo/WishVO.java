package com.lee.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishVO {
    private int wid;
    private int uid;
    private int pid;
    private String pname;
    private String price;
    private String image;
}
