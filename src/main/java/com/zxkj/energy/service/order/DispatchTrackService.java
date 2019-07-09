package com.zxkj.energy.service.order;

import com.zxkj.energy.mapper.order.DispatchTrackMapper;
import com.zxkj.energy.pojo.order.DispatchTrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxkj.energy.config.exception.FailException;
import com.zxkj.energy.enums.ResultEnum;
import java.util.List;

/**
 * 订单调派物流跟踪记录
 *
 * @author 刘万琼
 */
@Service
public class DispatchTrackService {
    private DispatchTrackMapper dispatchTrackMapper;

    @Autowired
    public DispatchTrackService(DispatchTrackMapper dispatchTrackMapper) {
        this.dispatchTrackMapper = dispatchTrackMapper;
    }

    /**
     * 方法描述：添加记录.
     * 创建时间：2019-06-28 14:16:44
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public Boolean insert(DispatchTrack record) {
        return dispatchTrackMapper.insertSelective(record) == 1;
    }

    /**
     * 方法描述：通过记录id删除记录.
     * 创建时间：2019-06-28 14:16:44
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public Boolean deleteById(Long id) {
        return dispatchTrackMapper.deleteById(id) == 1;
    }

    /**
     * 方法描述：更新记录.
     * 创建时间：2019-06-28 14:16:44
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public DispatchTrack update(DispatchTrack record) {
        if (dispatchTrackMapper.updateByPrimaryKeySelective(record) == 1) {
            return dispatchTrackMapper.selectByPrimaryKey(record.getId());
        }
        throw new FailException(ResultEnum.ERROR_MODIFY);
    }

    /**
     * 方法描述：根据记录id查询记录.
     * 创建时间：2019-06-28 14:16:44
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public DispatchTrack selectById(Long id) {
        return dispatchTrackMapper.selectByPrimaryKey(id);
    }

    /**
     * 方法描述：根据 查询对象 查询出单条记录.
     * 创建时间：2019-06-28 14:16:44
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public DispatchTrack find(DispatchTrack record) {
        return dispatchTrackMapper.find(record);
    }

    /**
     * 方法描述：根据 查询对象 查询出列表记录.
     * 创建时间：2019-06-28 14:16:44
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public List<DispatchTrack> list(DispatchTrack record) {
        return dispatchTrackMapper.list(record);
    }

}
