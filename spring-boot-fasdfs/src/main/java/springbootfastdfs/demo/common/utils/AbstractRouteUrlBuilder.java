package springbootfastdfs.demo.common.utils;

import org.springframework.web.util.UriComponentsBuilder;
import springbootfastdfs.demo.common.emums.PermitTypeEnum;
import springbootfastdfs.demo.common.exception.BusinessException;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * routeUrl工具类
 * </p>
 *
 * @author LiXiang
 * @date 2020/7/10 15:13
 */
public interface AbstractRouteUrlBuilder {

    String getBaseUrl();

    /**
     * 构建不可分享的h5页面
     *
     * @param title      标题
     * @param canShare   是否可分享
     * @param url        目标url
     * @param permitType 授权类型，0无限制(默认)，1需登录，2需激活信用，3需绑车
     * @return h5页面url
     */
    default String buildH5Page(String title, boolean canShare, String url, PermitTypeEnum permitType) {
        return buildH5Page(title, canShare, url, permitType, null, null, null);
    }

    /**
     * 构建可分享的h5页面
     *
     * @param title         标题
     * @param canShare      是否可分享
     * @param url           目标url
     * @param permitType    授权类型，0无限制(默认)，1需登录，2需激活信用，3需绑车
     * @param shareTitle    分享标题
     * @param shareSummary  分享摘要，超过50字符末尾打…
     * @param shareImageUrl 分享图标
     * @return h5页面url
     */
    default String buildH5Page(String title, boolean canShare, String url, PermitTypeEnum permitType,
                               String shareTitle, String shareSummary, String shareImageUrl) {
        if (title == null) {
            throw new BusinessException("h5's title is null");
        }

        if (url == null) {
            throw new BusinessException("h5's url is null");
        }

        int permitTypeCode;
        if (permitType == null) {
            permitTypeCode = PermitTypeEnum.TOURIST.getCode();
        } else {
            permitTypeCode = permitType.getCode();
        }

        if (shareTitle == null) {
            shareTitle = "";
        }

        if (shareSummary == null) {
            shareSummary = "";
        }

        if (shareImageUrl == null) {
            shareImageUrl = "";
        }

        String template = getBaseUrl() + "/html/remoteHtml?title={title}&canShare={canShare}&url={url}"
                + "&permitType={permitType}&shareTitle={shareTitle}&shareSummary={shareSummary}&shareImageUrl={shareImageUrl}";
        return UriComponentsBuilder.fromUriString(template)
                .build(title, canShare, url, permitTypeCode, shareTitle, shareSummary, shareImageUrl).toString();
    }

    default String buildNativePage(String suffix, Object... uriVariables) {
        return getBaseUrl() + UriComponentsBuilder.fromUriString(suffix).build(uriVariables).toString();
    }

    default String buildNativePage(String suffix, Map<String, Object> uriVariables) {
        return getBaseUrl() + UriComponentsBuilder.fromUriString(suffix).build(uriVariables).toString();
    }

    default String buildNativePageDirect(String suffix, Map<String, Object> uriVariables) {
        return UriComponentsBuilder.fromUriString(suffix).build(uriVariables).toString();
    }

    default String buildH5PageDirect(String suffix, Map<String, Object> baseVariables, Map<String, Object> uriVariables) {
        Map<String, Object> variables = new HashMap<>();
        if (baseVariables != null) {
            variables.putAll(baseVariables);
        }
        if (uriVariables != null) {
            variables.putAll(uriVariables);
        }
        return UriComponentsBuilder.fromUriString(suffix).build(variables).toString();
    }
}
