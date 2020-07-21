package springbootfastdfs.demo.common.params.resp;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author LiXiang
 * @date 2020/7/18 17:54
 */
@Data
@NoArgsConstructor
@Accessors
public class FileUploadRes {
    /**
     * 视频上传路径
     */
    private String url;
    /**
     * 视频上传全路径
     */
    private String fullUrl;
}
