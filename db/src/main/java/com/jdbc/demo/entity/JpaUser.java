package com.jdbc.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity    // 标识当前实体为数据实体类
@Data    // 自动生成get/set等
@Table(name = "t_user") // 标识实体对应的表名
@EntityListeners(AuditingEntityListener.class) // spring-data-jap实体类数据更新的监听器注解
public class JpaUser {
    // 标识当前属性为主键列属性
    @Id
    // 标识字段列的主键策略（主键生成方式）GenerationType.IDENTITY表示shiyongMySQL默认自增长生成主键值
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 标识当前属性对应数据库的字段
    @Column(name = "user_name")
    private String userName;
    @Column(name = "note")
    private String note;
    @Column(name = "sex")
    private Integer sex;

    // spring-data-jap中提供的自动填充，新增时自动填充时间（配合SPRING-DATA-JPA监听注解使用）
    @CreatedDate
    private Date createTime;

    // spring-data-jap中提供的自动填充，有更新时自动填充更新时间（配合SPING-DATA-JPA监听注解使用）
    @LastModifiedDate
    private Date modifyTime;
}