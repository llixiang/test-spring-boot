package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 实体类
 *
 * @author LiXiang
 * @date 2020/6/1 16:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Goods {

    private Long id;
    private String name;
    private Integer sort;
    private String position;
    private Double weight;
    private String color;
    private LocalDateTime createDate;
    private LocalDateTime updateTime;
}