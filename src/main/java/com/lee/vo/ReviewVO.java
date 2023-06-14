package com.lee.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewVO {
    private int uid;
    private String date;
    private String type;
    private String title;
    private String content;
    private String username;
}
