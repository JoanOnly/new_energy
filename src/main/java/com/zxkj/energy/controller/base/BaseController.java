package com.zxkj.energy.controller.base;

import com.zxkj.energy.enums.ResultEnum;
import com.zxkj.energy.pojo.base.CommonResult;
import org.springframework.stereotype.Controller;

/**
 * @author 刘万琼
 * <p>
 * 控制层基类
 */
@Controller
public class BaseController {

    /**
     * 方法描述：返回结果带数据
     * 创建时间：2019-06-21 09:31:24
     * 创建作者：刘万琼
     *
     * @param resultEnum the result enum
     * @param object     the object
     * @return the common result
     */
    protected CommonResult resultWrapper(ResultEnum resultEnum, Object object) {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(resultEnum.getCode());
        commonResult.setMsg(resultEnum.getMessage());
        commonResult.setData(object);
        return commonResult;
    }

    /**
     * 方法描述：返回结果无数据
     * 创建时间：2019-06-21 09:32:20
     * 创建作者：刘万琼
     *
     * @param resultEnum the result enum
     * @return the common result
     */
    private CommonResult resultWrapper(ResultEnum resultEnum) {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(resultEnum.getCode());
        commonResult.setMsg(resultEnum.getMessage());
        return commonResult;
    }

    /**
     * 方法描述：bool 返回结果无数据
     * 创建时间：2019-06-21 09:56:02
     * 创建作者：刘万琼
     *
     * @param bool       the bool
     * @param resultEnum the result enum
     * @return the common result
     */
    protected CommonResult resultWrapper(Boolean bool, ResultEnum resultEnum) {
        return resultWrapper(bool ? resultEnum : ResultEnum.ERROR);
    }

}
