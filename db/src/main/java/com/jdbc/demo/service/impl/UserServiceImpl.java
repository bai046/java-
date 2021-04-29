package com.jdbc.demo.service.impl;

import com.jdbc.demo.entity.JpaUser;
import com.jdbc.demo.entity.User;
import com.jdbc.demo.repository.JpaUserRepository;
import com.jdbc.demo.repository.UserDao;
import com.jdbc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Path;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserById(Long id) {
        return userDao.findUserById(id);
    }

    @Override
    public List<User> selectUserList() {
        return userDao.selectUserList();
    }

    @Autowired
    private JpaUserRepository jpaUserRepository;

    @Override
    public JpaUser saveUser(JpaUser jpaUser) {
        return jpaUserRepository.save(jpaUser);
    }

    @Override
    public JpaUser findJpaUserById(Long id) {
        return jpaUserRepository.findJpaUserById(id);
    }

    @Override
    public List<JpaUser> queryById(String userName) {
        return jpaUserRepository.queryById(userName);
    }

    @Override
    public List<JpaUser> findAllByName(String userName) {
        Specification<JpaUser> spec = (Specification<JpaUser>) (root, criteriaQuery, criteriaBuilder) -> {
            //根据属性名获取查询对象的属性
            Path<JpaUser> path = root.get("userName");
            //相当于 where userName = "Xyshqwe", CriteriaBuilder接口中还有很多查询条件，建议看源码
            return criteriaBuilder.equal(path, "Xyshqwe");
        };

        Integer pageNo = 2;
        Integer pageSize = 4;
        /**
         * 添加排序Sort
         *      Sort.Direction.DESC表示降序
         *      Sort.Direction.ASC表示升序
         *      properties是指实体类的属性名（不是字段名）
         */
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        /**
         *  分页参数Pageable
         *      参数1：查询的页码
         *      参数2：每页查询的条数
         *      参数3：查询结果的排序规则（可选
         */
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort); //原来的new PageRequest()已经过时

        return jpaUserRepository.findAll(spec);
    }

    @Override
    public Page<JpaUser> queryPageById(Pageable pageable) {
        return jpaUserRepository.findAll(pageable);
    }
}
