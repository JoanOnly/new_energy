package com.zxkj.energy.service.car;

import com.zxkj.energy.mapper.car.CarDriverMapper;
import com.zxkj.energy.pojo.car.CarDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxkj.energy.config.exception.FailException;
import com.zxkj.energy.enums.ResultEnum;
import java.util.List;

/**
 * 车辆司机表:同一个车有多个司机
 *
 * @author 刘万琼
 */
@Service
public class CarDriverService {
    private CarDriverMapper carDriverMapper;

    @Autowired
    public CarDriverService(CarDriverMapper carDriverMapper) {
        this.carDriverMapper = carDriverMapper;
    }

    /**
     * 方法描述：添加记录.
     * 创建时间：2019-06-28 14:22:14
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public Boolean insert(CarDriver record) {
        return carDriverMapper.insertSelective(record) == 1;
    }

    /**
     * 方法描述：通过记录id删除记录.
     * 创建时间：2019-06-28 14:22:14
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public Boolean deleteById(Long id) {
        return carDriverMapper.deleteById(id) == 1;
    }

    /**
     * 方法描述：更新记录.
     * 创建时间：2019-06-28 14:22:14
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public CarDriver update(CarDriver record) {
        if (carDriverMapper.updateByPrimaryKeySelective(record) == 1) {
            return carDriverMapper.selectByPrimaryKey(record.getId());
        }
        throw new FailException(ResultEnum.ERROR_MODIFY);
    }

    /**
     * 方法描述：根据记录id查询记录.
     * 创建时间：2019-06-28 14:22:14
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public CarDriver selectById(Long id) {
        return carDriverMapper.selectByPrimaryKey(id);
    }

    /**
     * 方法描述：根据 查询对象 查询出单条记录.
     * 创建时间：2019-06-28 14:22:14
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public CarDriver find(CarDriver record) {
        return carDriverMapper.find(record);
    }

    /**
     * 方法描述：根据 查询对象 查询出列表记录.
     * 创建时间：2019-06-28 14:22:14
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public List<CarDriver> list(CarDriver record) {
        return carDriverMapper.list(record);
    }

}
