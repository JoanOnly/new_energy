package com.zxkj.energy.service.order;

import com.zxkj.energy.mapper.order.OrderInfoMapper;
import com.zxkj.energy.pojo.order.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxkj.energy.config.exception.FailException;
import com.zxkj.energy.enums.ResultEnum;
import java.util.List;

/**
 * 订单管理
 *
 * @author 刘万琼
 */
@Service
public class OrderInfoService {
    private OrderInfoMapper orderMapper;

    @Autowired
    public OrderInfoService(OrderInfoMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    /**
     * 方法描述：添加记录.
     * 创建时间：2019-06-28 10:52:05
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public Boolean insert(OrderInfo record) {
        return orderMapper.insertSelective(record) == 1;
    }

    /**
     * 方法描述：通过记录id删除记录.
     * 创建时间：2019-06-28 10:52:05
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public Boolean deleteById(Long id) {
        return orderMapper.deleteById(id) == 1;
    }

    /**
     * 方法描述：更新记录.
     * 创建时间：2019-06-28 10:52:05
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public OrderInfo update(OrderInfo record) {
        if (orderMapper.updateByPrimaryKeySelective(record) == 1) {
            return orderMapper.selectByPrimaryKey(record.getId());
        }
        throw new FailException(ResultEnum.ERROR_MODIFY);
    }

    /**
     * 方法描述：根据记录id查询记录.
     * 创建时间：2019-06-28 10:52:05
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public OrderInfo selectById(Long id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    /**
     * 方法描述：根据 查询对象 查询出单条记录.
     * 创建时间：2019-06-28 10:52:05
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public OrderInfo find(OrderInfo record) {
        return orderMapper.find(record);
    }

    /**
     * 方法描述：根据 查询对象 查询出列表记录.
     * 创建时间：2019-06-28 10:52:05
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public List<OrderInfo> list(OrderInfo record) {
        return orderMapper.list(record);
    }

}
