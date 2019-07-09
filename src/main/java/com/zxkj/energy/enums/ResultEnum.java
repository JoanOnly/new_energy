package com.zxkj.energy.enums;

import lombok.Getter;

/**
 * @author 刘万琼
 */
@Getter
public enum ResultEnum {
    /******* 0 ~ 1999 为成功信息，以 SUCCESS_ 开头******/
    SUCCESS(1000, "成功"),
    SUCCESS_LOAD(1001, "加载成功"),
    SUCCESS_INSERT(1002, "添加成功"),
    SUCCESS_SAVE(1003, "保存成功"),
    SUCCESS_MODIFY(1004, "修改成功"),
    SUCCESS_DELETE(1005, "删除成功"),
    SUCCESS_ACTION(1006, "操作成功"),
    SUCCESS_SEND(1007, "发送成功，请注意查收"),
    SUCCESS_BIND(1008, "绑定成功"),
    SUCCESS_BIND_CHANGE(1009, "换绑成功"),
    SUCCESS_REAL_NAME(1010, "认证成功"),

    /******* 2000 ~ 9999 为失败信息，以 ERROR_ 开头 ******/
    ERROR(2000, "失败"),
    ERROR_LOAD(2001, "加载失败"),
    ERROR_INSERT(2002, "添加失败"),
    ERROR_SAVE(2003, "保存失败"),
    ERROR_MODIFY(2004, "修改失败"),
    ERROR_DELETE(2005, "删除失败"),
    ERROR_ACTION(2006, "操作失败"),;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 方法描述：根据code返回枚举
     * 创建时间：2019-06-21 09:19:37
     * 创建作者：刘万琼
     *
     * @param code the code
     * @return the result enum
     */
    public static ResultEnum codeToEnum(int code) {
        for (ResultEnum resultEnum : ResultEnum.values()) {
            if (code == resultEnum.getCode()) {
                return resultEnum;
            }
        }
        return null;
    }
}
