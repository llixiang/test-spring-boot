package springbootelasticsearch.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootelasticsearch.demo.Model.User;
import springbootelasticsearch.demo.repository.UserRepository;
import springbootelasticsearch.demo.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author LiXiang
 * @date 2020/6/30 10:27
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        if (user == null) {
            return null;
        }
        System.out.println(userRepository);
        return userRepository.save(user);
    }

    @Override
    public User findUserById(Long id) {
        if (id == null) {
            return null;
        }
        //Optional 是 Java 语言的有益补充 —— 它旨在减少代码中的 NullPointerExceptions，虽然还不能完全消除这些异常
        //Optional 类是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
        //Optional 是个容器：它可以保存类型T的值，或者仅仅保存null。Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
        //Optional 类的引入很好的解决空指针异常。
        //ifPresent 用于对过滤出的数据如果存在。如果经过过滤条件后，有数据的话就可以进行修改。
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteUser() {
        userRepository.deleteAll();
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        Iterable<User> user = userRepository.findAll();
        user.forEach(item -> {
            userList.add(item);
        });
        return userList;
    }
}
