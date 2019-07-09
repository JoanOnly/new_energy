package com.zxkj.energy.controller.order;

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

import com.zxkj.energy.pojo.order.OrderCharge;
import com.zxkj.energy.service.order.OrderChargeService;

/**
 * 订单收费记录
 *
 * @author 刘万琼
 * @date：2019-06-28 14:08:44
 */
@RestController
@RequestMapping("/orderCharge")
public class OrderChargeCtl extends BaseController {
    private OrderChargeService orderChargeService;

    @Autowired
    public OrderChargeCtl(OrderChargeService record) {
        this.orderChargeService = record;
    }

    /**
     * 方法描述：添加
     * 创建时间：2019-06-28 14:08:44
     * 创建作者：刘万琼
     *
     * @param record the record
     * @return the common result
     */
    @PostMapping("/insert")
    public CommonResult insert(OrderCharge record) {
        return resultWrapper(orderChargeService.insert(record), ResultEnum.SUCCESS);
    }

    /**
     * 方法描述：逻辑删除
     * 创建时间：2019-06-28 14:08:44
     * 创建作者：刘万琼
     *
     * @param id the id
     * @return the common result
     */
    @PostMapping("/delete")
    public CommonResult delete(
            @RequestParam(value = "id", required = true) Long id
    ) {
        return resultWrapper(orderChargeService.deleteById(id), ResultEnum.SUCCESS_DELETE);
    }

    /**
     * 方法描述：修改
     * 创建时间：2019-06-28 14:08:44
     * 创建作者：刘万琼
     *
     * @param record the record
     * @return the common result
     */
    @PostMapping("/update")
    public CommonResult update(OrderCharge record) {
        return resultWrapper(ResultEnum.SUCCESS_MODIFY, orderChargeService.update(record));
    }

    /**
     * 方法描述：根据id查询单条信息
     * 创建时间：2019-06-28 14:08:44
     * 创建作者：刘万琼
     *
     * @param id the id
     * @return the common result
     */
    @PostMapping("/getInfo")
    public CommonResult selectById(
            @RequestParam(value = "id", required = true) Long id
    ) {
        return resultWrapper(ResultEnum.SUCCESS_LOAD, orderChargeService.selectById(id));
    }

    /**
     * 方法描述：分页
     * 创建时间：2019-06-28 14:08:44
     * 创建作者：刘万琼
     *
     * @param record the record
     * @return the page
     */
    @PostMapping("/getPage")
    @Paging
    public Page<OrderCharge> page(OrderCharge record) {
        return new Page<>(orderChargeService.list(record));
    }
}

