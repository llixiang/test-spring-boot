package springbootfastdfs.demo.common.configbean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import springbootfastdfs.demo.common.utils.AbstractRouteUrlBuilder;

/**
 * @author LiXiang
 * @date 2020/7/10 16:15
 */
@Data
@ConfigurationProperties("biz.route")
@Component
public class RouteConfigBean implements AbstractRouteUrlBuilder {

    private String baseUrl;
}
