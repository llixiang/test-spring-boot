package springbootfastdfs.demo.common.params.resp;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * @author LiXiang
 * @date 2020/7/7 19:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.ALWAYS)
@Accessors(chain = true)
public class RecommendRes {
    /**
     * 文章id
     */
    private String articleId;

    /**
     * banner标题
     */
    private String title;

    /**
     * banner图片路径url
     */
    @NotNull(message = "推荐的文章必须有封面。请上传文章封面")
    private String image;

    /**
     * banner图片全路径
     */
    //封面设置必须开着
    @NotNull(message = "推荐的文章必须有封面。请上传文章封面")
    private String fullImage;

    /**
     * 跳转路径
     */
    private String routeUrl;

}
