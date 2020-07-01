package springbootjava8.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author LiXiang
 * @date 2020/6/30 15:50
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
