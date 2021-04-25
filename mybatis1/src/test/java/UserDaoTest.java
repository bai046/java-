import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import ying.one.MybatisUtils;
import ying.one.User;
import ying.one.UserDao;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        //获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一:getMapper
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();
        //方式二
//        List<User> userList = sqlSession.selectList("ying.one.UserDao.getUserList");

        for (User user : userList) {
            System.out.println(user);
        }//显示数据库中储存的数据

        //关闭sqlSession
        sqlSession.close();
    }

}
