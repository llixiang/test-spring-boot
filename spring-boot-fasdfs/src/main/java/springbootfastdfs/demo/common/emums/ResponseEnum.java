package springbootfastdfs.demo.common.emums;

/**
 * 返回报文enum
 *
 * @author LiXiang
 * @date 2020/7/1 17:33
 */
public enum ResponseEnum {
    /**
     * 系统异常
     */
    EXECUTE_EXCEPTION(500, "系统异常");

    private int code;
    private String msg;

    ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
