package springbootelasticsearch.demo.Model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * @author LiXiang
 * @date 2020/6/30 10:46
 */
public class IndexName {
    @Value("${etrali.indexname}")
    private String indexName;

    @Bean
    public String indexName() {
        return indexName;
    }
}
