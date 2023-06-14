package com.lee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    private int id;
    private int pid;
    private String image1;
    private String image2;
    private String image3;
    private String image4;
}
