package com.zxkj.energy.config.exception;

import com.zxkj.energy.enums.ResultEnum;

/**
 * @author 刘万琼
 *
 * 抛出失败异常
 */
public class FailException extends RuntimeException {

    private Integer code;
    private Object object;

    public Object getData() {
        return object;
    }

    public void setData(Object object) {
        this.object = object;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public FailException() {
        super();
    }

    public FailException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public FailException(ResultEnum resultEnum, Object object) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
        this.object = object;
    }
}
