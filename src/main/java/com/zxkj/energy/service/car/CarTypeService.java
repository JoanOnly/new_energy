package com.zxkj.energy.service.car;

import com.zxkj.energy.mapper.car.CarTypeMapper;
import com.zxkj.energy.pojo.car.CarType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxkj.energy.config.exception.FailException;
import com.zxkj.energy.enums.ResultEnum;
import java.util.List;

/**
 * 车辆类型表
 *
 * @author 刘万琼
 */
@Service
public class CarTypeService {
    private CarTypeMapper carTypeMapper;

    @Autowired
    public CarTypeService(CarTypeMapper carTypeMapper) {
        this.carTypeMapper = carTypeMapper;
    }

    /**
     * 方法描述：添加记录.
     * 创建时间：2019-06-28 14:21:20
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public Boolean insert(CarType record) {
        return carTypeMapper.insertSelective(record) == 1;
    }

    /**
     * 方法描述：通过记录id删除记录.
     * 创建时间：2019-06-28 14:21:20
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public Boolean deleteById(Long id) {
        return carTypeMapper.deleteById(id) == 1;
    }

    /**
     * 方法描述：更新记录.
     * 创建时间：2019-06-28 14:21:20
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public CarType update(CarType record) {
        if (carTypeMapper.updateByPrimaryKeySelective(record) == 1) {
            return carTypeMapper.selectByPrimaryKey(record.getId());
        }
        throw new FailException(ResultEnum.ERROR_MODIFY);
    }

    /**
     * 方法描述：根据记录id查询记录.
     * 创建时间：2019-06-28 14:21:20
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public CarType selectById(Long id) {
        return carTypeMapper.selectByPrimaryKey(id);
    }

    /**
     * 方法描述：根据 查询对象 查询出单条记录.
     * 创建时间：2019-06-28 14:21:20
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public CarType find(CarType record) {
        return carTypeMapper.find(record);
    }

    /**
     * 方法描述：根据 查询对象 查询出列表记录.
     * 创建时间：2019-06-28 14:21:20
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public List<CarType> list(CarType record) {
        return carTypeMapper.list(record);
    }

}
