//与上面main中的对应更加规范
package com.ying.dao;

import com.ying.pojo.User;
import com.ying.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
//应用方法验证
import org.junit.Test;
import java.util.List;

public class UserDaoTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();
//        遍历打印
        for (User user : userList) {
            System.out.println(user.toString());
        }

//        养成关闭习惯
        sqlSession.close();
    }
}
