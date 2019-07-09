package com.zxkj.energy.service.user;

import com.zxkj.energy.mapper.user.DriverCarMapper;
import com.zxkj.energy.pojo.user.DriverCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxkj.energy.config.exception.FailException;
import com.zxkj.energy.enums.ResultEnum;
import java.util.List;

/**
 * 司机车辆表：同一个司机可以驾驶多个车
 *
 * @author 刘万琼
 */
@Service
public class DriverCarService {
    private DriverCarMapper driverCarMapper;

    @Autowired
    public DriverCarService(DriverCarMapper driverCarMapper) {
        this.driverCarMapper = driverCarMapper;
    }

    /**
     * 方法描述：添加记录.
     * 创建时间：2019-06-28 14:33:02
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public Boolean insert(DriverCar record) {
        return driverCarMapper.insertSelective(record) == 1;
    }

    /**
     * 方法描述：通过记录id删除记录.
     * 创建时间：2019-06-28 14:33:02
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public Boolean deleteById(Long id) {
        return driverCarMapper.deleteById(id) == 1;
    }

    /**
     * 方法描述：更新记录.
     * 创建时间：2019-06-28 14:33:02
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public DriverCar update(DriverCar record) {
        if (driverCarMapper.updateByPrimaryKeySelective(record) == 1) {
            return driverCarMapper.selectByPrimaryKey(record.getId());
        }
        throw new FailException(ResultEnum.ERROR_MODIFY);
    }

    /**
     * 方法描述：根据记录id查询记录.
     * 创建时间：2019-06-28 14:33:02
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public DriverCar selectById(Long id) {
        return driverCarMapper.selectByPrimaryKey(id);
    }

    /**
     * 方法描述：根据 查询对象 查询出单条记录.
     * 创建时间：2019-06-28 14:33:02
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public DriverCar find(DriverCar record) {
        return driverCarMapper.find(record);
    }

    /**
     * 方法描述：根据 查询对象 查询出列表记录.
     * 创建时间：2019-06-28 14:33:02
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public List<DriverCar> list(DriverCar record) {
        return driverCarMapper.list(record);
    }

}
