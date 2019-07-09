package com.zxkj.energy.service.user;

import com.zxkj.energy.config.exception.FailException;
import com.zxkj.energy.enums.ResultEnum;
import com.zxkj.energy.mapper.user.UserInfoMapper;
import com.zxkj.energy.pojo.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户信息
 *
 * @author 刘万琼
 */
@Service
public class UserInfoService {
    private UserInfoMapper userMapper;

    @Autowired
    public UserInfoService(UserInfoMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 方法描述：添加记录.
     * 创建时间：2019-06-28 10:11:27
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public Boolean insert(UserInfo record) {
        return userMapper.insertSelective(record) == 1;
    }

    /**
     * 方法描述：通过记录id删除记录.
     * 创建时间：2019-06-28 10:11:27
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public Boolean deleteById(Long id) {
        return userMapper.deleteById(id) == 1;
    }

    /**
     * 方法描述：更新记录.
     * 创建时间：2019-06-28 10:11:27
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public UserInfo update(UserInfo record) {
        if (userMapper.updateByPrimaryKeySelective(record) == 1) {
            return userMapper.selectByPrimaryKey(record.getId());
        }
        throw new FailException(ResultEnum.ERROR_MODIFY);
    }

    /**
     * 方法描述：根据记录id查询记录.
     * 创建时间：2019-06-28 10:11:27
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public UserInfo selectById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 方法描述：根据 查询对象 查询出单条记录.
     * 创建时间：2019-06-28 10:11:27
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public UserInfo find(UserInfo record) {
        return userMapper.find(record);
    }

    /**
     * 方法描述：根据 查询对象 查询出列表记录.
     * 创建时间：2019-06-28 10:11:27
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public List<UserInfo> list(UserInfo record) {
        return userMapper.list(record);
    }

}
