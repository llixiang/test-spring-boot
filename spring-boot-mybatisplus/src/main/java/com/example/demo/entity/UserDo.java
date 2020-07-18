package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author LiXiang
 * @date 2020/7/14 11:00
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserDo {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
