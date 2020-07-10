package springbootfastdfs.demo.common.params.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * 文件上传返回类
 *
 * @author hekunlin
 */
@Data
public class FastDfsUploadResp implements Serializable {

    /**
     * 文件相对路径
     */
    private String relativePath;

    /**
     * 文件全路径
     */
    private String fullPath;

}