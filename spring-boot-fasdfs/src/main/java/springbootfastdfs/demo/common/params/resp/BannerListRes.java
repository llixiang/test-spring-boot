package springbootfastdfs.demo.common.params.resp;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

/**
 * @author LiXiang
 * @date 2020/7/7 15:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.ALWAYS)
public class BannerListRes {

    @Valid
    private List<RecommendRes> bannerList;//banner列表
}
