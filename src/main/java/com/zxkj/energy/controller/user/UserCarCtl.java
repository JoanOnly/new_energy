package com.zxkj.energy.controller.user;

import com.zxkj.energy.system.page.Paging;
import com.zxkj.energy.controller.base.BaseController;
import com.zxkj.energy.enums.ResultEnum;
import com.zxkj.energy.pojo.base.CommonResult;
import com.zxkj.energy.system.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zxkj.energy.pojo.user.UserCar;
import com.zxkj.energy.service.user.UserCarService;

/**
 * 车主名下的车：一个用户拥有多个车
 *
 * @author 刘万琼
 * @date：2019-06-28 14:31:25
 */
@RestController
@RequestMapping("/userCar")
public class UserCarCtl extends BaseController {
    private UserCarService userCarService;

    @Autowired
    public UserCarCtl(UserCarService record) {
        this.userCarService = record;
    }

    /**
     * 方法描述：添加
     * 创建时间：2019-06-28 14:31:25
     * 创建作者：刘万琼
     *
     * @param record the record
     * @return the common result
     */
    @PostMapping("/insert")
    public CommonResult insert(UserCar record) {
        return resultWrapper(userCarService.insert(record), ResultEnum.SUCCESS);
    }

    /**
     * 方法描述：逻辑删除
     * 创建时间：2019-06-28 14:31:25
     * 创建作者：刘万琼
     *
     * @param id the id
     * @return the common result
     */
    @PostMapping("/delete")
    public CommonResult delete(
            @RequestParam(value = "id", required = true) Long id
    ) {
        return resultWrapper(userCarService.deleteById(id), ResultEnum.SUCCESS_DELETE);
    }

    /**
     * 方法描述：修改
     * 创建时间：2019-06-28 14:31:25
     * 创建作者：刘万琼
     *
     * @param record the record
     * @return the common result
     */
    @PostMapping("/update")
    public CommonResult update(UserCar record) {
        return resultWrapper(ResultEnum.SUCCESS_MODIFY, userCarService.update(record));
    }

    /**
     * 方法描述：根据id查询单条信息
     * 创建时间：2019-06-28 14:31:25
     * 创建作者：刘万琼
     *
     * @param id the id
     * @return the common result
     */
    @PostMapping("/getInfo")
    public CommonResult selectById(
            @RequestParam(value = "id", required = true) Long id
    ) {
        return resultWrapper(ResultEnum.SUCCESS_LOAD, userCarService.selectById(id));
    }

    /**
     * 方法描述：分页
     * 创建时间：2019-06-28 14:31:25
     * 创建作者：刘万琼
     *
     * @param record the record
     * @return the page
     */
    @PostMapping("/getPage")
    @Paging
    public Page<UserCar> page(UserCar record) {
        return new Page<>(userCarService.list(record));
    }
}

