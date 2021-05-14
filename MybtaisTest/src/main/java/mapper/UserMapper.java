package mapper;

import dao.User;

//用户查询接口
public interface UserMapper {

    //查询一个用户
    public User select(int id);
}
