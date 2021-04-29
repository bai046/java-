package com.jdbc.demo.repository;

import com.jdbc.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired // 注入jdbcTemplate
    private JdbcTemplate jdbcTemplate;

    public User findUserById(Long id) {
        User user = jdbcTemplate.queryForObject("select * from t_user where id =?",
                new BeanPropertyRowMapper<>(User.class), id);

        return user;
    }

    /**
     * 插入数据
     */
    public void insertPerson(User p) {
        jdbcTemplate.update("INSERT INTO t_user(user_name, sex) VALUES (?,?)",
                p.getUserName(), p.getSex());
    }

    /**
     * 查询所有
     * 方法query可以查询多行多列。
     * 参数1：SQL
     * 参数2：一个结果集处理器（取决于查询的结果和需求）
     * 参数3：可变参数
     */
    public List<User> selectUserList() {
        List<User> userList = jdbcTemplate.query("SELECT * FROM t_user",
                new BeanPropertyRowMapper<>(User.class));
        return userList;
    }
}
