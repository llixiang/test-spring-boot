package springbootfastdfs.demo.common.statuscode;

/**
 * 状态码抽象接口
 *
 * @author LiXiang
 * @date 2020/7/1 17:21
 */
public interface IStatusCode {
    /**
     * 状态码
     */
    long getCode();

    /**
     * 描述信息
     */
    String getMsg();
}
