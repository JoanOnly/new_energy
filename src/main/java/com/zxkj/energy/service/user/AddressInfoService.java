package com.zxkj.energy.service.user;

import com.zxkj.energy.mapper.user.AddressInfoMapper;
import com.zxkj.energy.pojo.user.AddressInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxkj.energy.config.exception.FailException;
import com.zxkj.energy.enums.ResultEnum;
import java.util.List;

/**
 * 用户地址管理
 *
 * @author 刘万琼
 */
@Service
public class AddressInfoService {
    private AddressInfoMapper addressInfoMapper;

    @Autowired
    public AddressInfoService(AddressInfoMapper addressInfoMapper) {
        this.addressInfoMapper = addressInfoMapper;
    }

    /**
     * 方法描述：添加记录.
     * 创建时间：2019-06-28 14:34:00
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public Boolean insert(AddressInfo record) {
        return addressInfoMapper.insertSelective(record) == 1;
    }

    /**
     * 方法描述：通过记录id删除记录.
     * 创建时间：2019-06-28 14:34:00
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public Boolean deleteById(Long id) {
        return addressInfoMapper.deleteById(id) == 1;
    }

    /**
     * 方法描述：更新记录.
     * 创建时间：2019-06-28 14:34:00
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public AddressInfo update(AddressInfo record) {
        if (addressInfoMapper.updateByPrimaryKeySelective(record) == 1) {
            return addressInfoMapper.selectByPrimaryKey(record.getId());
        }
        throw new FailException(ResultEnum.ERROR_MODIFY);
    }

    /**
     * 方法描述：根据记录id查询记录.
     * 创建时间：2019-06-28 14:34:00
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public AddressInfo selectById(Long id) {
        return addressInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 方法描述：根据 查询对象 查询出单条记录.
     * 创建时间：2019-06-28 14:34:00
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public AddressInfo find(AddressInfo record) {
        return addressInfoMapper.find(record);
    }

    /**
     * 方法描述：根据 查询对象 查询出列表记录.
     * 创建时间：2019-06-28 14:34:00
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public List<AddressInfo> list(AddressInfo record) {
        return addressInfoMapper.list(record);
    }

}
