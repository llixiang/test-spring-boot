package com.example.demo.dateformat;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author LiXiang
 * @date 2020/6/8 9:53
 */
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormatResp {

    // -----------------------------------------------------------------------------------------------
    // DATE
    // -----------------------------------------------------------------------------------------------

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deleteDate;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date searchDate;

    // -----------------------------------------------------------------------------------------------
    // LocalDateTime
    // -----------------------------------------------------------------------------------------------

    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //private LocalDateTime localCrateDate;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    //private LocalDateTime localDeleteDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime localUpdateDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localSearchDate;

}
