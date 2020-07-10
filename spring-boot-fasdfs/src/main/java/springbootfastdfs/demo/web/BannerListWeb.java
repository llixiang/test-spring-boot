package springbootfastdfs.demo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootfastdfs.demo.common.params.resp.BannerListRes;
import springbootfastdfs.demo.core.BannerListService;

/**
 * @author LiXiang
 * @date 2020/7/10 16:00
 */
@Slf4j
@RestController
@RequestMapping("/article")
@Validated
public class BannerListWeb {
    @Autowired
    private BannerListService service;

    @GetMapping("/bannerList")
    public BannerListRes bannerList() {
        return service.bannerList();
    }
}
