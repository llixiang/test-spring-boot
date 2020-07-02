package springbootfastdfs.demo.common.apiparam;

import lombok.Data;
import springbootfastdfs.demo.common.statuscode.StatusCode;

/**
 * 统一的返回结果，作为服务间进行通信的数据协议
 * code表示状态码，不同服务不同接口会返回不同的状态码
 * msg表示返回的结果信息描述
 * errorMsg 表示返回的错误信息描述
 * data作为泛型参数类型，在不同接口可以定义不同类型
 *
 * @author LiXiang
 * @date 2020/7/1 17:12
 */
@Data
public class Response<T> {
    /**
     * 成功标记
     */
    private boolean success = true;

    /**
     * 状态码
     */
    private long code = StatusCode.SUCCESS.getCode();
    /**
     * 描述
     */
    private String msg = StatusCode.SUCCESS.getMsg();
    /**
     * 错误描述
     */
    private String errorMsg = StatusCode.SUCCESS.getMsg();
    /**
     * 挂载数据
     */
    private T data;
}
