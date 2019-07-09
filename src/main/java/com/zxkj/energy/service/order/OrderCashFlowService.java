package com.zxkj.energy.service.order;

import com.zxkj.energy.mapper.order.OrderCashFlowMapper;
import com.zxkj.energy.pojo.order.OrderCashFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxkj.energy.config.exception.FailException;
import com.zxkj.energy.enums.ResultEnum;
import java.util.List;

/**
 * 订单资金流动记录
 *
 * @author 刘万琼
 */
@Service
public class OrderCashFlowService {
    private OrderCashFlowMapper orderCashFlowMapper;

    @Autowired
    public OrderCashFlowService(OrderCashFlowMapper orderCashFlowMapper) {
        this.orderCashFlowMapper = orderCashFlowMapper;
    }

    /**
     * 方法描述：添加记录.
     * 创建时间：2019-06-28 14:14:06
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public Boolean insert(OrderCashFlow record) {
        return orderCashFlowMapper.insertSelective(record) == 1;
    }

    /**
     * 方法描述：通过记录id删除记录.
     * 创建时间：2019-06-28 14:14:06
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public Boolean deleteById(Long id) {
        return orderCashFlowMapper.deleteById(id) == 1;
    }

    /**
     * 方法描述：更新记录.
     * 创建时间：2019-06-28 14:14:06
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public OrderCashFlow update(OrderCashFlow record) {
        if (orderCashFlowMapper.updateByPrimaryKeySelective(record) == 1) {
            return orderCashFlowMapper.selectByPrimaryKey(record.getId());
        }
        throw new FailException(ResultEnum.ERROR_MODIFY);
    }

    /**
     * 方法描述：根据记录id查询记录.
     * 创建时间：2019-06-28 14:14:06
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public OrderCashFlow selectById(Long id) {
        return orderCashFlowMapper.selectByPrimaryKey(id);
    }

    /**
     * 方法描述：根据 查询对象 查询出单条记录.
     * 创建时间：2019-06-28 14:14:06
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public OrderCashFlow find(OrderCashFlow record) {
        return orderCashFlowMapper.find(record);
    }

    /**
     * 方法描述：根据 查询对象 查询出列表记录.
     * 创建时间：2019-06-28 14:14:06
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public List<OrderCashFlow> list(OrderCashFlow record) {
        return orderCashFlowMapper.list(record);
    }

}
