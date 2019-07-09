package com.zxkj.energy.service.user;

import com.zxkj.energy.mapper.user.AccountInfoMapper;
import com.zxkj.energy.pojo.user.AccountInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxkj.energy.config.exception.FailException;
import com.zxkj.energy.enums.ResultEnum;
import java.util.List;

/**
 * 用户账户管理
 *
 * @author 刘万琼
 */
@Service
public class AccountInfoService {
    private AccountInfoMapper accountInfoMapper;

    @Autowired
    public AccountInfoService(AccountInfoMapper accountInfoMapper) {
        this.accountInfoMapper = accountInfoMapper;
    }

    /**
     * 方法描述：添加记录.
     * 创建时间：2019-06-28 14:36:25
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public Boolean insert(AccountInfo record) {
        return accountInfoMapper.insertSelective(record) == 1;
    }

    /**
     * 方法描述：通过记录id删除记录.
     * 创建时间：2019-06-28 14:36:25
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public Boolean deleteById(Long id) {
        return accountInfoMapper.deleteById(id) == 1;
    }

    /**
     * 方法描述：更新记录.
     * 创建时间：2019-06-28 14:36:25
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public AccountInfo update(AccountInfo record) {
        if (accountInfoMapper.updateByPrimaryKeySelective(record) == 1) {
            return accountInfoMapper.selectByPrimaryKey(record.getId());
        }
        throw new FailException(ResultEnum.ERROR_MODIFY);
    }

    /**
     * 方法描述：根据记录id查询记录.
     * 创建时间：2019-06-28 14:36:25
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public AccountInfo selectById(Long id) {
        return accountInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 方法描述：根据 查询对象 查询出单条记录.
     * 创建时间：2019-06-28 14:36:25
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public AccountInfo find(AccountInfo record) {
        return accountInfoMapper.find(record);
    }

    /**
     * 方法描述：根据 查询对象 查询出列表记录.
     * 创建时间：2019-06-28 14:36:25
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public List<AccountInfo> list(AccountInfo record) {
        return accountInfoMapper.list(record);
    }

}
