package com.zxkj.energy.service.car;

import com.zxkj.energy.mapper.car.CarInfoMapper;
import com.zxkj.energy.pojo.car.CarInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxkj.energy.config.exception.FailException;
import com.zxkj.energy.enums.ResultEnum;
import java.util.List;

/**
 * 车辆表
 *
 * @author 刘万琼
 */
@Service
public class CarInfoService {
    private CarInfoMapper carMapper;

    @Autowired
    public CarInfoService(CarInfoMapper carMapper) {
        this.carMapper = carMapper;
    }

    /**
     * 方法描述：添加记录.
     * 创建时间：2019-06-28 10:43:57
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public Boolean insert(CarInfo record) {
        return carMapper.insertSelective(record) == 1;
    }

    /**
     * 方法描述：通过记录id删除记录.
     * 创建时间：2019-06-28 10:43:57
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public Boolean deleteById(Long id) {
        return carMapper.deleteById(id) == 1;
    }

    /**
     * 方法描述：更新记录.
     * 创建时间：2019-06-28 10:43:57
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public CarInfo update(CarInfo record) {
        if (carMapper.updateByPrimaryKeySelective(record) == 1) {
            return carMapper.selectByPrimaryKey(record.getId());
        }
        throw new FailException(ResultEnum.ERROR_MODIFY);
    }

    /**
     * 方法描述：根据记录id查询记录.
     * 创建时间：2019-06-28 10:43:57
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public CarInfo selectById(Long id) {
        return carMapper.selectByPrimaryKey(id);
    }

    /**
     * 方法描述：根据 查询对象 查询出单条记录.
     * 创建时间：2019-06-28 10:43:57
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public CarInfo find(CarInfo record) {
        return carMapper.find(record);
    }

    /**
     * 方法描述：根据 查询对象 查询出列表记录.
     * 创建时间：2019-06-28 10:43:57
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public List<CarInfo> list(CarInfo record) {
        return carMapper.list(record);
    }

}
