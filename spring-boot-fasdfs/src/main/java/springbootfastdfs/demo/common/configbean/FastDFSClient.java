package springbootfastdfs.demo.common.configbean;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author LiXiang
 * @date 2020/7/20 18:13
 */
@Component
public class FastDFSClient {

    @Autowired
    private FastFileStorageClient storageClient;

    /**
     * 上传文件
     *
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException
     */
    public String uploadFile(MultipartFile file) throws IOException {
        StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
        return storePath.getFullPath();
    }

    /**
     * 上传文件
     *
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException
     */
    public String uploadFile(byte[] file, String fileName) throws IOException {
        StorePath storePath = storageClient.uploadFile(new ByteArrayInputStream(file), file.length, FilenameUtils.getExtension(fileName), null);
        return storePath.getFullPath();
    }

    /**
     * 封装图片完整URL地址
     *
     * @param storePath
     * @return
     * @link https://blog.csdn.net/ityqing/article/details/81384740
     */
    private String getResAccessUrl(StorePath storePath) {
        String fileUrl = storePath.getFullPath();
        return fileUrl;
    }

    public byte[] download(String fileUrl) {
        int idx = fileUrl.indexOf("/", 1);
        String group = fileUrl.substring(1, idx);
        String path = fileUrl.substring(idx + 1);
        return storageClient.downloadFile(group, path, new DownloadByteArray());
    }
}
