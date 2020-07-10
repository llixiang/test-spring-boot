package springbootfastdfs.demo.common.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import springbootfastdfs.demo.common.statuscode.IStatusCode;
import springbootfastdfs.demo.common.statuscode.StatusCode;

/**
 * @author LiXiang
 * @date 2020/7/10 15:20
 */
@Getter
@Setter
@Accessors(chain = true)
public class BusinessException extends RuntimeException {


    private long code; // 状态码
    private String msg; // 消息
    private String errorMsg; // 错误消息
    private Object param; // 附加参数

    public BusinessException(IStatusCode sc) {
        super();
        set(sc.getCode(), sc.getMsg(), sc.getMsg());
    }

    public BusinessException(String msg, String errorMsg) {
        super();
        set(StatusCode.SYSTEM_ERROR.getCode(), msg, errorMsg);
    }

    public BusinessException(IStatusCode sc, String msg) {
        super();
        set(sc.getCode(), msg, msg);
    }

    public BusinessException(IStatusCode sc, String msg, String errorMsg) {
        super();
        set(sc.getCode(), msg, errorMsg);
    }

    public BusinessException(Throwable throwable) {
        super(throwable);
        if (throwable instanceof BusinessException) {
            BusinessException cast = (BusinessException) throwable;
            set(cast.code, cast.msg, cast.errorMsg);
            setParam(cast.param);
        } else {
            set(StatusCode.SYSTEM_ERROR.getCode(), StatusCode.SYSTEM_ERROR.getMsg(), throwable.toString());
        }
    }

    public BusinessException(Throwable throwable, IStatusCode sc, String msg) {
        super(throwable);
        set(sc.getCode(), msg, msg);
    }

    public BusinessException(long code, String msg) {
        super();
        set(code, msg, msg);
    }

    public BusinessException(String msg) {
        super();
        set(StatusCode.BUSINESS_ERROR.getCode(), msg, msg);
    }

    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(code);

        if (msg != null) {
            sb.append(", msg=").append(msg);
        }

        if (errorMsg != null) {
            sb.append(", errorMsg=").append(errorMsg);
        }

        if (param != null) {
            sb.append(", param=").append(param);
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return this.getClass().getName() + ":" + getMessage();
    }

    private void set(long code, String msg, String errorMsg) {
        this.code = code;
        this.msg = msg;
        this.errorMsg = errorMsg;
    }
}
