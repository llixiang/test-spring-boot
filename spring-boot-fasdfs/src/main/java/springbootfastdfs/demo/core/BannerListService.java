package springbootfastdfs.demo.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import springbootfastdfs.demo.common.configbean.FastDfsConfigBeanImg;
import springbootfastdfs.demo.common.configbean.RouteConfigBean;
import springbootfastdfs.demo.common.params.resp.BannerListRes;
import springbootfastdfs.demo.common.params.resp.RecommendRes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiXiang
 * @date 2020/7/10 16:01
 */
@Service
@Slf4j
@Component
public class BannerListService {
    @Autowired
    private FastDfsConfigBeanImg fastDfsConfigBean;
    @Autowired
    private RouteConfigBean routeConfigBean;


    //为了测试代码正确性，所以才注释掉全路径的和setRouteUrl，因为变成了静态类，真正写的时候不用静态就可以直接使用注释掉的东西获得全路径和返回的url
    public static BannerListRes bannerList() {
        BannerListRes resp = new BannerListRes();
        RecommendRes res = new RecommendRes();
        List<RecommendRes> list = new ArrayList<>();
        res.setArticleId("1")
                .setTitle("文章标题")
                .setImage("/group1/M00/00/12/rBoUOV1StriANp0rAAHc0XpEA0I812.jpg")
                .setFullImage("chevrejjkv")
                //.setFullImage(res.getImage() != null ? fastDfsConfigBean.genUrl(res.getImage()) : null)
                .setRouteUrl("很常见的吃哦文化v测吧");
//                .setRouteUrl(routeConfigBean.buildH5Page(res.getTitle(), true, "这里的url可以从业务层那边取得配置在Apollo上面的相关前缀信息，会约定好",
//                        PermitTypeEnum.TOURIST, res.getTitle(), res.getTitle(), res.getImage()));
        list.add(res);
        resp.setBannerList(list);
        return resp;
    }


    public static void main(String[] args) {
        BannerListRes bannerListRes = bannerList();
        System.err.println("==>--------------" + bannerListRes);
    }
}
