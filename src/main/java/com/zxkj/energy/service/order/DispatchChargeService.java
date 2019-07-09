package com.zxkj.energy.service.order;

import com.zxkj.energy.mapper.order.DispatchChargeMapper;
import com.zxkj.energy.pojo.order.DispatchCharge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxkj.energy.config.exception.FailException;
import com.zxkj.energy.enums.ResultEnum;
import java.util.List;

/**
 * 订单调派信息收费记录
 *
 * @author 刘万琼
 */
@Service
public class DispatchChargeService {
    private DispatchChargeMapper dispatchChargeMapper;

    @Autowired
    public DispatchChargeService(DispatchChargeMapper dispatchChargeMapper) {
        this.dispatchChargeMapper = dispatchChargeMapper;
    }

    /**
     * 方法描述：添加记录.
     * 创建时间：2019-06-28 14:18:01
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public Boolean insert(DispatchCharge record) {
        return dispatchChargeMapper.insertSelective(record) == 1;
    }

    /**
     * 方法描述：通过记录id删除记录.
     * 创建时间：2019-06-28 14:18:01
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public Boolean deleteById(Long id) {
        return dispatchChargeMapper.deleteById(id) == 1;
    }

    /**
     * 方法描述：更新记录.
     * 创建时间：2019-06-28 14:18:01
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public DispatchCharge update(DispatchCharge record) {
        if (dispatchChargeMapper.updateByPrimaryKeySelective(record) == 1) {
            return dispatchChargeMapper.selectByPrimaryKey(record.getId());
        }
        throw new FailException(ResultEnum.ERROR_MODIFY);
    }

    /**
     * 方法描述：根据记录id查询记录.
     * 创建时间：2019-06-28 14:18:01
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public DispatchCharge selectById(Long id) {
        return dispatchChargeMapper.selectByPrimaryKey(id);
    }

    /**
     * 方法描述：根据 查询对象 查询出单条记录.
     * 创建时间：2019-06-28 14:18:01
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public DispatchCharge find(DispatchCharge record) {
        return dispatchChargeMapper.find(record);
    }

    /**
     * 方法描述：根据 查询对象 查询出列表记录.
     * 创建时间：2019-06-28 14:18:01
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public List<DispatchCharge> list(DispatchCharge record) {
        return dispatchChargeMapper.list(record);
    }

}
