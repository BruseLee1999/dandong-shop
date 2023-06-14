package com.lee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private int rid;
    private int pid;
    private int uid;
    private String date;
    private String type;
    private String title;
    private String content;
}
