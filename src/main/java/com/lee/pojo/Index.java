package com.lee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Index {
    private int i_id;
    private String title;
    private String name;
    private String content;
    private String detail;
    private String image;
}
