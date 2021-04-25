package com.ying.utils;
//实体工具类
//alt+回车自动导入包
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
//SqlSessionFactoryBuilder建造--> sqlSessionFactory 会话工厂--> sqlSession会话
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
//    生成静态代码块
    static {
        try {
//使用Mybatis第一步：获取sqlSessionFactory对象（原始api连接SQL）
            String resource = "mybatis-config.xml";
            InputStream inputStream =
                    Resources.getResourceAsStream(resource);
            sqlSessionFactory = new
                    SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//既然有了sqlSessionFactory，顾名思义，我们就可以从中获得SqlSession的实例了
    //SqlSession 完全包含了面向数据库执行 SQL 命令所需的所有方法
    public static SqlSession getSqlSession() {
//SqlSession sqlSession = sqlSessionFactory.openSession(); 拿到session
        sqlSessionFactory.openSession();
//return sqlSession;
        return sqlSessionFactory.openSession();
    }
}
