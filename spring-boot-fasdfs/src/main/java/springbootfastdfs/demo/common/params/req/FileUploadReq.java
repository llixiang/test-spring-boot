package springbootfastdfs.demo.common.params.req;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * @author LiXiang
 * @date 2020/7/18 18:17
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class FileUploadReq {

    @NotNull(message = "文件上传失败，参数不能为空")
    private MultipartFile file;

}
