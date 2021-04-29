package com.jdbc.demo.repository;

import com.jdbc.demo.entity.JpaUser;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 编写DAO接口继承JpaRepository接口
 * 泛型参数1：CURD实体类型
 * 泛型参数2：主键的类型（通常为Integer或Long）
 */
public interface JpaUserRepository extends JpaRepository<JpaUser, Integer>,
        JpaSpecificationExecutor<JpaUser> {

    JpaUser findJpaUserById(Long id);

    /**
     * * @Query进行 自定义sql编写
     * * nativeQuery=true：表示定义的SQL为标准SQL（没有这一项，SQL语句中的表名和字段名是实体类名和实体类中的字段名）
     * * 传参数使用占位符？代替，但需要注意的是这里的占位符后面需要跟数字（第几个？N 数字N从1开始）
     */
    @Query(value = "select * from t_user where user_name = ?1", nativeQuery = true)
    List<JpaUser> queryById(String userName);

    // 使用自定义命名方法名规则，进行查询服务，并添加分页功能
    List<JpaUser> findByUserNameContaining(String name, Pageable pageable);// …… where name like ‘%?%’

}
