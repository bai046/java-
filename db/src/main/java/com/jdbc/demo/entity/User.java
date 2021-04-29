package com.jdbc.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Long id;

    private String userName;

    private String note;

    private Integer sex;

    private Date createTime;
}
