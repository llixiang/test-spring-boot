package springbootfastdfs.demo.core;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import springbootfastdfs.demo.common.configbean.FastDFSClient;
import springbootfastdfs.demo.common.configbean.FastDfsConfigBeanImg;
import springbootfastdfs.demo.common.configbean.FileSuffixConstants;
import springbootfastdfs.demo.common.exception.BusinessException;
import springbootfastdfs.demo.common.params.resp.FileUploadRes;

import javax.annotation.Resource;

/**
 * @author LiXiang
 * @date 2020/7/20 15:09
 */
@Slf4j
@Service
@Component
public class FileUploadService {
    @Resource
    private FastDFSClient fastDFSClient;
    @Resource
    private FastDfsConfigBeanImg fastDfsConfigBeanImg;


    public FileUploadRes upload(MultipartFile file) {
        if (file.isEmpty()) {
            log.error("file upload fail, file is empty!");
            throw new BusinessException("文件上传失败");
        }

        if (StringUtils.isEmpty(file.getName())) {
            throw new BusinessException("文件上传失败");
        }

        //file.getOriginalFilename()是得到上传时的文件名。
        //.lastIndexOf(String str): 返回指定子字符串在此字符串中最右边出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
        //.substring("")返回一个新字符串，它是此字符串的一个子字符串。该子字符串始于指定索引处的字符，一直到此字符串末尾。
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

        if (!(FileSuffixConstants.ANDROID_TYPE_APK.equals(suffix.toUpperCase()) ||
                FileSuffixConstants.EXCEL_TYPE_XLS.equals(suffix.toUpperCase()) ||
                FileSuffixConstants.EXCEL_TYPE_XLSX.equals(suffix.toUpperCase()) ||
                FileSuffixConstants.IMG_TYPE_DMG.equals(suffix.toUpperCase()) ||
                FileSuffixConstants.IMG_TYPE_GIF.equals(suffix.toUpperCase()) ||
                FileSuffixConstants.IMG_TYPE_JPEG.equals(suffix.toUpperCase()) ||
                FileSuffixConstants.IMG_TYPE_JPG.equals(suffix.toUpperCase()) ||
                FileSuffixConstants.IMG_TYPE_PNG.equals(suffix.toUpperCase()) ||
                FileSuffixConstants.IMG_TYPE_SVG.equals(suffix.toUpperCase()) ||
                FileSuffixConstants.VIDEO_TYPE_MP4.equals(suffix.toUpperCase()))) {
            throw new BusinessException("文件上传失败，不支持的文件格式");
        }

        String url = uploadFile(file);

        if (url == null) {
            log.error("file upload fail,service error");
            throw new BusinessException("文件上传失败");
        }

        FileUploadRes res = new FileUploadRes();
        res.setUrl(url);
        res.setFullUrl(fastDfsConfigBeanImg.genUrl(url));

        return res;
    }

    public String uploadFile(MultipartFile file) {
        try {
            //将文件上装到fast文件服务器上，成功则返回文件保存的路径
            String path = fastDFSClient.uploadFile(file);
            if (!org.springframework.util.StringUtils.hasText(path)) {
                log.error("Upload Img Error");
                throw new BusinessException("上传图片失败");
            }
            log.info("Upload Img Success. path {}", ("/group" + path.split("group")[1]));

            return "/group" + path.split("group")[1];
        } catch (Exception e) {
            log.error("Upload Img Error, msg ={}", e);
            throw new BusinessException("上传图片失败");
        }
    }
}
