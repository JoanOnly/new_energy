package com.zxkj.energy.controller.car;

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

import com.zxkj.energy.pojo.car.CarArchives;
import com.zxkj.energy.service.car.CarArchivesService;

/**
 * 车辆档案管理
 *
 * @author 刘万琼
 * @date：2019-06-28 14:23:04
 */
@RestController
@RequestMapping("/carArchives")
public class CarArchivesCtl extends BaseController {
    private CarArchivesService carArchivesService;

    @Autowired
    public CarArchivesCtl(CarArchivesService record) {
        this.carArchivesService = record;
    }

    /**
     * 方法描述：添加
     * 创建时间：2019-06-28 14:23:04
     * 创建作者：刘万琼
     *
     * @param record the record
     * @return the common result
     */
    @PostMapping("/insert")
    public CommonResult insert(CarArchives record) {
        return resultWrapper(carArchivesService.insert(record), ResultEnum.SUCCESS);
    }

    /**
     * 方法描述：逻辑删除
     * 创建时间：2019-06-28 14:23:04
     * 创建作者：刘万琼
     *
     * @param id the id
     * @return the common result
     */
    @PostMapping("/delete")
    public CommonResult delete(
            @RequestParam(value = "id", required = true) Long id
    ) {
        return resultWrapper(carArchivesService.deleteById(id), ResultEnum.SUCCESS_DELETE);
    }

    /**
     * 方法描述：修改
     * 创建时间：2019-06-28 14:23:04
     * 创建作者：刘万琼
     *
     * @param record the record
     * @return the common result
     */
    @PostMapping("/update")
    public CommonResult update(CarArchives record) {
        return resultWrapper(ResultEnum.SUCCESS_MODIFY, carArchivesService.update(record));
    }

    /**
     * 方法描述：根据id查询单条信息
     * 创建时间：2019-06-28 14:23:04
     * 创建作者：刘万琼
     *
     * @param id the id
     * @return the common result
     */
    @PostMapping("/getInfo")
    public CommonResult selectById(
            @RequestParam(value = "id", required = true) Long id
    ) {
        return resultWrapper(ResultEnum.SUCCESS_LOAD, carArchivesService.selectById(id));
    }

    /**
     * 方法描述：分页
     * 创建时间：2019-06-28 14:23:04
     * 创建作者：刘万琼
     *
     * @param record the record
     * @return the page
     */
    @PostMapping("/getPage")
    @Paging
    public Page<CarArchives> page(CarArchives record) {
        return new Page<>(carArchivesService.list(record));
    }
}

