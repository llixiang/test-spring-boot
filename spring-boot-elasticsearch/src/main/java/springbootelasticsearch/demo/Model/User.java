package springbootelasticsearch.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author LiXiang
 * @date 2020/6/30 9:46
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
//动态indexName  @Document
//@Document(indexName="#{@indexName}")
@Document(indexName = "lxxxx-user", shards = 1, replicas = 0, refreshInterval = "-1")
public class User {
    @Id
    private Long id;
    private String name;
    private Integer age;
    private String remark;

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + ", remark=" + remark + "]";
    }
}
