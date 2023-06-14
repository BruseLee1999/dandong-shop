package com.lee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Detail {
    private int pid;
    private String weight;
    private String area;
    private String pack;
    private String domestic;
}
