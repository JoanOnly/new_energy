package com.zxkj.energy.service.order;

import com.zxkj.energy.mapper.order.DispatchInfoMapper;
import com.zxkj.energy.pojo.order.DispatchInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxkj.energy.config.exception.FailException;
import com.zxkj.energy.enums.ResultEnum;
import java.util.List;

/**
 * 订单调派记录记录
 *
 * @author 刘万琼
 */
@Service
public class DispatchInfoService {
    private DispatchInfoMapper dispatchInfoMapper;

    @Autowired
    public DispatchInfoService(DispatchInfoMapper dispatchInfoMapper) {
        this.dispatchInfoMapper = dispatchInfoMapper;
    }

    /**
     * 方法描述：添加记录.
     * 创建时间：2019-06-28 14:15:30
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public Boolean insert(DispatchInfo record) {
        return dispatchInfoMapper.insertSelective(record) == 1;
    }

    /**
     * 方法描述：通过记录id删除记录.
     * 创建时间：2019-06-28 14:15:30
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public Boolean deleteById(Long id) {
        return dispatchInfoMapper.deleteById(id) == 1;
    }

    /**
     * 方法描述：更新记录.
     * 创建时间：2019-06-28 14:15:30
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public DispatchInfo update(DispatchInfo record) {
        if (dispatchInfoMapper.updateByPrimaryKeySelective(record) == 1) {
            return dispatchInfoMapper.selectByPrimaryKey(record.getId());
        }
        throw new FailException(ResultEnum.ERROR_MODIFY);
    }

    /**
     * 方法描述：根据记录id查询记录.
     * 创建时间：2019-06-28 14:15:30
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public DispatchInfo selectById(Long id) {
        return dispatchInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 方法描述：根据 查询对象 查询出单条记录.
     * 创建时间：2019-06-28 14:15:30
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public DispatchInfo find(DispatchInfo record) {
        return dispatchInfoMapper.find(record);
    }

    /**
     * 方法描述：根据 查询对象 查询出列表记录.
     * 创建时间：2019-06-28 14:15:30
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public List<DispatchInfo> list(DispatchInfo record) {
        return dispatchInfoMapper.list(record);
    }

}
