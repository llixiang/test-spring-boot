package springbootfastdfs.demo.common.configbean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author LiXiang
 * @date 2020/7/1 17:40
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "biz.fastdfs")
public class FastDfsConfigBean {
    /**
     * 文件访问地址
     */
    private String httpUrl;
}
