package springbootfastdfs.demo.common.configbean;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Apollo  配置的注解及位置：需要在Apollo上配置：
 * biz.fastdfs.baseUrl = http://devimg.hikcreate.com
 * biz.fastdfs.baseSourceUrl = http://img.hikcreate.com
 * </p>
 *
 * @author LiXiang
 * @date 2020/7/10 15:03
 */
@Data
@ConfigurationProperties("biz.fastdfs")
@Component
public class FastDfsConfigBeanImg {

    /**
     * fastdfs图标地址
     */
    private String baseSourceUrl;

    /**
     * FastDfs地址
     */
    private String baseUrl;

    /**
     * 生成完成的文件地址
     *
     * @param suffix 后缀
     * @return 完整地址
     */
    public String genSourceUrl(String suffix) {
        if (StringUtils.isBlank(suffix)) {
            return "";
        }
        if (!suffix.startsWith("/")) {
            suffix = "/" + suffix;
        }
        return baseSourceUrl + suffix;
    }

    /**
     * 生成完成的文件地址
     *
     * @param suffix 后缀
     * @return 完整地址
     */
    public String genUrl(String suffix) {
        if (StringUtils.isBlank(suffix)) {
            return "";
        }
        if (!suffix.startsWith("/")) {
            suffix = "/" + suffix;
        }
        return baseUrl + suffix;
    }
}