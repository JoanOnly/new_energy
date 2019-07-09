package com.zxkj.energy.service.car;

import com.zxkj.energy.mapper.car.CarArchivesMapper;
import com.zxkj.energy.pojo.car.CarArchives;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxkj.energy.config.exception.FailException;
import com.zxkj.energy.enums.ResultEnum;
import java.util.List;

/**
 * 车辆档案管理
 *
 * @author 刘万琼
 */
@Service
public class CarArchivesService {
    private CarArchivesMapper carArchivesMapper;

    @Autowired
    public CarArchivesService(CarArchivesMapper carArchivesMapper) {
        this.carArchivesMapper = carArchivesMapper;
    }

    /**
     * 方法描述：添加记录.
     * 创建时间：2019-06-28 14:23:04
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public Boolean insert(CarArchives record) {
        return carArchivesMapper.insertSelective(record) == 1;
    }

    /**
     * 方法描述：通过记录id删除记录.
     * 创建时间：2019-06-28 14:23:04
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public Boolean deleteById(Long id) {
        return carArchivesMapper.deleteById(id) == 1;
    }

    /**
     * 方法描述：更新记录.
     * 创建时间：2019-06-28 14:23:04
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public CarArchives update(CarArchives record) {
        if (carArchivesMapper.updateByPrimaryKeySelective(record) == 1) {
            return carArchivesMapper.selectByPrimaryKey(record.getId());
        }
        throw new FailException(ResultEnum.ERROR_MODIFY);
    }

    /**
     * 方法描述：根据记录id查询记录.
     * 创建时间：2019-06-28 14:23:04
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public CarArchives selectById(Long id) {
        return carArchivesMapper.selectByPrimaryKey(id);
    }

    /**
     * 方法描述：根据 查询对象 查询出单条记录.
     * 创建时间：2019-06-28 14:23:04
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public CarArchives find(CarArchives record) {
        return carArchivesMapper.find(record);
    }

    /**
     * 方法描述：根据 查询对象 查询出列表记录.
     * 创建时间：2019-06-28 14:23:04
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public List<CarArchives> list(CarArchives record) {
        return carArchivesMapper.list(record);
    }

}
