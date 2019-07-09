package com.zxkj.energy.service.user;

import com.zxkj.energy.mapper.user.UserCarMapper;
import com.zxkj.energy.pojo.user.UserCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxkj.energy.config.exception.FailException;
import com.zxkj.energy.enums.ResultEnum;
import java.util.List;

/**
 * 车主名下的车：一个用户拥有多个车
 *
 * @author 刘万琼
 */
@Service
public class UserCarService {
    private UserCarMapper userCarMapper;

    @Autowired
    public UserCarService(UserCarMapper userCarMapper) {
        this.userCarMapper = userCarMapper;
    }

    /**
     * 方法描述：添加记录.
     * 创建时间：2019-06-28 14:31:25
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public Boolean insert(UserCar record) {
        return userCarMapper.insertSelective(record) == 1;
    }

    /**
     * 方法描述：通过记录id删除记录.
     * 创建时间：2019-06-28 14:31:25
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public Boolean deleteById(Long id) {
        return userCarMapper.deleteById(id) == 1;
    }

    /**
     * 方法描述：更新记录.
     * 创建时间：2019-06-28 14:31:25
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public UserCar update(UserCar record) {
        if (userCarMapper.updateByPrimaryKeySelective(record) == 1) {
            return userCarMapper.selectByPrimaryKey(record.getId());
        }
        throw new FailException(ResultEnum.ERROR_MODIFY);
    }

    /**
     * 方法描述：根据记录id查询记录.
     * 创建时间：2019-06-28 14:31:25
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public UserCar selectById(Long id) {
        return userCarMapper.selectByPrimaryKey(id);
    }

    /**
     * 方法描述：根据 查询对象 查询出单条记录.
     * 创建时间：2019-06-28 14:31:25
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public UserCar find(UserCar record) {
        return userCarMapper.find(record);
    }

    /**
     * 方法描述：根据 查询对象 查询出列表记录.
     * 创建时间：2019-06-28 14:31:25
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public List<UserCar> list(UserCar record) {
        return userCarMapper.list(record);
    }

}
