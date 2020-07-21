package springbootfastdfs.demo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootfastdfs.demo.common.params.req.FileUploadReq;
import springbootfastdfs.demo.common.params.resp.FileUploadRes;
import springbootfastdfs.demo.core.FileUploadService;

/**
 * @author LiXiang
 * @date 2020/7/18 18:15
 */
@RestController
@Slf4j
@RequestMapping("/file")
@Validated
public class FileUploadWeb {
    @Autowired
    private FileUploadService fileUploadService;

    @GetMapping("/upload")
    public FileUploadRes upload(@Validated FileUploadReq req) {
        return fileUploadService.upload(req.getFile());
    }
}
