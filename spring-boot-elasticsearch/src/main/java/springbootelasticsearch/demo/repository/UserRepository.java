package springbootelasticsearch.demo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import springbootelasticsearch.demo.Model.User;

/**
 * @author LiXiang
 * @date 2020/6/30 10:35
 */
public interface UserRepository extends ElasticsearchRepository<User, Long> {
}
