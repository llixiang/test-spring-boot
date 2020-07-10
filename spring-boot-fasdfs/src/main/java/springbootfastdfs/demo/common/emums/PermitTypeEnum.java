package springbootfastdfs.demo.common.emums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiXiang
 * @date 2020/7/10 15:27
 */
@Getter
@AllArgsConstructor
public enum PermitTypeEnum {

    TOURIST(0, "游客身份可进入"),
    LOGIN(1, "需要登录才能进入"),
    CREDIT(2, "需要激活交通信用才能进入"),
    BIND_VEHICLE(3, "需要绑定车辆才能进入");

    private int code;
    private String name;

    private static Map<Integer, PermitTypeEnum> valueMap = new HashMap<>();

    static {
        for (PermitTypeEnum item : PermitTypeEnum.values()) {
            valueMap.put(item.getCode(), item);
        }
    }

    public static PermitTypeEnum get(Integer code) {
        PermitTypeEnum result = valueMap.get(code);
        if (result == null) {
            throw new NullPointerException("can not get PermitTypeEnum by code for " + code);
        }
        return result;
    }
}
