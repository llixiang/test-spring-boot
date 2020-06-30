package springbootelasticsearch.demo.service;

import springbootelasticsearch.demo.Model.User;

import java.util.List;

/**
 * @author LiXiang
 * @date 2020/6/30 10:26
 */
public interface UserService {
    /**
     * 添加用户
     */
    User saveUser(User user);

    /**
     * 根据id查找用户
     */
    User findUserById(Long id);

    /**
     * 根据id删除
     */
    void deleteById(Long id);

    /**
     * 删除
     */
    void deleteUser();

    /**
     * 查找列表
     */
    List<User> findAll();
}
