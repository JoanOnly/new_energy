package com.zxkj.energy.service.order;

import com.zxkj.energy.mapper.order.OrderBackCashMapper;
import com.zxkj.energy.pojo.order.OrderBackCash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxkj.energy.config.exception.FailException;
import com.zxkj.energy.enums.ResultEnum;
import java.util.List;

/**
 * 订单退款记录
 *
 * @author 刘万琼
 */
@Service
public class OrderBackCashService {
    private OrderBackCashMapper orderBackCashMapper;

    @Autowired
    public OrderBackCashService(OrderBackCashMapper orderBackCashMapper) {
        this.orderBackCashMapper = orderBackCashMapper;
    }

    /**
     * 方法描述：添加记录.
     * 创建时间：2019-06-28 11:55:23
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public Boolean insert(OrderBackCash record) {
        return orderBackCashMapper.insertSelective(record) == 1;
    }

    /**
     * 方法描述：通过记录id删除记录.
     * 创建时间：2019-06-28 11:55:23
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public Boolean deleteById(Long id) {
        return orderBackCashMapper.deleteById(id) == 1;
    }

    /**
     * 方法描述：更新记录.
     * 创建时间：2019-06-28 11:55:23
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public OrderBackCash update(OrderBackCash record) {
        if (orderBackCashMapper.updateByPrimaryKeySelective(record) == 1) {
            return orderBackCashMapper.selectByPrimaryKey(record.getId());
        }
        throw new FailException(ResultEnum.ERROR_MODIFY);
    }

    /**
     * 方法描述：根据记录id查询记录.
     * 创建时间：2019-06-28 11:55:23
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public OrderBackCash selectById(Long id) {
        return orderBackCashMapper.selectByPrimaryKey(id);
    }

    /**
     * 方法描述：根据 查询对象 查询出单条记录.
     * 创建时间：2019-06-28 11:55:23
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public OrderBackCash find(OrderBackCash record) {
        return orderBackCashMapper.find(record);
    }

    /**
     * 方法描述：根据 查询对象 查询出列表记录.
     * 创建时间：2019-06-28 11:55:23
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public List<OrderBackCash> list(OrderBackCash record) {
        return orderBackCashMapper.list(record);
    }

}
