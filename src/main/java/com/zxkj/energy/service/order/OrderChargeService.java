package com.zxkj.energy.service.order;

import com.zxkj.energy.mapper.order.OrderChargeMapper;
import com.zxkj.energy.pojo.order.OrderCharge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxkj.energy.config.exception.FailException;
import com.zxkj.energy.enums.ResultEnum;
import java.util.List;

/**
 * 订单收费记录
 *
 * @author 刘万琼
 */
@Service
public class OrderChargeService {
    private OrderChargeMapper orderChargeMapper;

    @Autowired
    public OrderChargeService(OrderChargeMapper orderChargeMapper) {
        this.orderChargeMapper = orderChargeMapper;
    }

    /**
     * 方法描述：添加记录.
     * 创建时间：2019-06-28 14:08:43
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public Boolean insert(OrderCharge record) {
        return orderChargeMapper.insertSelective(record) == 1;
    }

    /**
     * 方法描述：通过记录id删除记录.
     * 创建时间：2019-06-28 14:08:43
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public Boolean deleteById(Long id) {
        return orderChargeMapper.deleteById(id) == 1;
    }

    /**
     * 方法描述：更新记录.
     * 创建时间：2019-06-28 14:08:43
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public OrderCharge update(OrderCharge record) {
        if (orderChargeMapper.updateByPrimaryKeySelective(record) == 1) {
            return orderChargeMapper.selectByPrimaryKey(record.getId());
        }
        throw new FailException(ResultEnum.ERROR_MODIFY);
    }

    /**
     * 方法描述：根据记录id查询记录.
     * 创建时间：2019-06-28 14:08:43
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public OrderCharge selectById(Long id) {
        return orderChargeMapper.selectByPrimaryKey(id);
    }

    /**
     * 方法描述：根据 查询对象 查询出单条记录.
     * 创建时间：2019-06-28 14:08:43
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public OrderCharge find(OrderCharge record) {
        return orderChargeMapper.find(record);
    }

    /**
     * 方法描述：根据 查询对象 查询出列表记录.
     * 创建时间：2019-06-28 14:08:43
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public List<OrderCharge> list(OrderCharge record) {
        return orderChargeMapper.list(record);
    }

}
