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

import com.zxkj.energy.pojo.user.DriverCar;
import com.zxkj.energy.service.user.DriverCarService;

/**
 * 司机车辆表：同一个司机可以驾驶多个车
 *
 * @author 刘万琼
 * @date：2019-06-28 14:33:02
 */
@RestController
@RequestMapping("/driverCar")
public class DriverCarCtl extends BaseController {
    private DriverCarService driverCarService;

    @Autowired
    public DriverCarCtl(DriverCarService record) {
        this.driverCarService = record;
    }

    /**
     * 方法描述：添加
     * 创建时间：2019-06-28 14:33:02
     * 创建作者：刘万琼
     *
     * @param record the record
     * @return the common result
     */
    @PostMapping("/insert")
    public CommonResult insert(DriverCar record) {
        return resultWrapper(driverCarService.insert(record), ResultEnum.SUCCESS);
    }

    /**
     * 方法描述：逻辑删除
     * 创建时间：2019-06-28 14:33:02
     * 创建作者：刘万琼
     *
     * @param id the id
     * @return the common result
     */
    @PostMapping("/delete")
    public CommonResult delete(
            @RequestParam(value = "id", required = true) Long id
    ) {
        return resultWrapper(driverCarService.deleteById(id), ResultEnum.SUCCESS_DELETE);
    }

    /**
     * 方法描述：修改
     * 创建时间：2019-06-28 14:33:02
     * 创建作者：刘万琼
     *
     * @param record the record
     * @return the common result
     */
    @PostMapping("/update")
    public CommonResult update(DriverCar record) {
        return resultWrapper(ResultEnum.SUCCESS_MODIFY, driverCarService.update(record));
    }

    /**
     * 方法描述：根据id查询单条信息
     * 创建时间：2019-06-28 14:33:02
     * 创建作者：刘万琼
     *
     * @param id the id
     * @return the common result
     */
    @PostMapping("/getInfo")
    public CommonResult selectById(
            @RequestParam(value = "id", required = true) Long id
    ) {
        return resultWrapper(ResultEnum.SUCCESS_LOAD, driverCarService.selectById(id));
    }

    /**
     * 方法描述：分页
     * 创建时间：2019-06-28 14:33:02
     * 创建作者：刘万琼
     *
     * @param record the record
     * @return the page
     */
    @PostMapping("/getPage")
    @Paging
    public Page<DriverCar> page(DriverCar record) {
        return new Page<>(driverCarService.list(record));
    }
}

