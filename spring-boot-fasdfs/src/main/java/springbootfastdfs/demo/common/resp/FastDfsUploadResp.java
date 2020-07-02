package springbootfastdfs.demo.common.resp;

import lombok.Data;

/**
 * @author LiXiang
 * @date 2020/7/1 17:37
 */
@Data
public class FastDfsUploadResp {
    /**
     * 文件相对路径
     */
    private String relativePath;
    /**
     * 文件全路径
     */
    private String fullPath;
}
