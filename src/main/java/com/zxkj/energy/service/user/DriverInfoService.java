package com.zxkj.energy.service.user;

import com.zxkj.energy.mapper.user.DriverInfoMapper;
import com.zxkj.energy.pojo.user.DriverInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxkj.energy.config.exception.FailException;
import com.zxkj.energy.enums.ResultEnum;
import java.util.List;

/**
 * 司机表（驾驶员表）
 *
 * @author 刘万琼
 */
@Service
public class DriverInfoService {
    private DriverInfoMapper driverInfoMapper;

    @Autowired
    public DriverInfoService(DriverInfoMapper driverInfoMapper) {
        this.driverInfoMapper = driverInfoMapper;
    }

    /**
     * 方法描述：添加记录.
     * 创建时间：2019-06-28 14:32:12
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public Boolean insert(DriverInfo record) {
        return driverInfoMapper.insertSelective(record) == 1;
    }

    /**
     * 方法描述：通过记录id删除记录.
     * 创建时间：2019-06-28 14:32:12
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public Boolean deleteById(Long id) {
        return driverInfoMapper.deleteById(id) == 1;
    }

    /**
     * 方法描述：更新记录.
     * 创建时间：2019-06-28 14:32:12
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public DriverInfo update(DriverInfo record) {
        if (driverInfoMapper.updateByPrimaryKeySelective(record) == 1) {
            return driverInfoMapper.selectByPrimaryKey(record.getId());
        }
        throw new FailException(ResultEnum.ERROR_MODIFY);
    }

    /**
     * 方法描述：根据记录id查询记录.
     * 创建时间：2019-06-28 14:32:12
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public DriverInfo selectById(Long id) {
        return driverInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 方法描述：根据 查询对象 查询出单条记录.
     * 创建时间：2019-06-28 14:32:12
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public DriverInfo find(DriverInfo record) {
        return driverInfoMapper.find(record);
    }

    /**
     * 方法描述：根据 查询对象 查询出列表记录.
     * 创建时间：2019-06-28 14:32:12
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public List<DriverInfo> list(DriverInfo record) {
        return driverInfoMapper.list(record);
    }

}
