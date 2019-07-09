package com.zxkj.energy.service.user;

import com.zxkj.energy.mapper.user.CompanyInfoMapper;
import com.zxkj.energy.pojo.user.CompanyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxkj.energy.config.exception.FailException;
import com.zxkj.energy.enums.ResultEnum;
import java.util.List;

/**
 * 公司
 *
 * @author 刘万琼
 */
@Service
public class CompanyInfoService {
    private CompanyInfoMapper companyInfoMapper;

    @Autowired
    public CompanyInfoService(CompanyInfoMapper companyInfoMapper) {
        this.companyInfoMapper = companyInfoMapper;
    }

    /**
     * 方法描述：添加记录.
     * 创建时间：2019-06-28 14:38:31
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public Boolean insert(CompanyInfo record) {
        return companyInfoMapper.insertSelective(record) == 1;
    }

    /**
     * 方法描述：通过记录id删除记录.
     * 创建时间：2019-06-28 14:38:31
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public Boolean deleteById(Long id) {
        return companyInfoMapper.deleteById(id) == 1;
    }

    /**
     * 方法描述：更新记录.
     * 创建时间：2019-06-28 14:38:31
     * 创建作者：刘万琼
     *
     * @param record 记录对象
     */
    public CompanyInfo update(CompanyInfo record) {
        if (companyInfoMapper.updateByPrimaryKeySelective(record) == 1) {
            return companyInfoMapper.selectByPrimaryKey(record.getId());
        }
        throw new FailException(ResultEnum.ERROR_MODIFY);
    }

    /**
     * 方法描述：根据记录id查询记录.
     * 创建时间：2019-06-28 14:38:31
     * 创建作者：刘万琼
     *
     * @param id 记录id
     */
    public CompanyInfo selectById(Long id) {
        return companyInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 方法描述：根据 查询对象 查询出单条记录.
     * 创建时间：2019-06-28 14:38:31
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public CompanyInfo find(CompanyInfo record) {
        return companyInfoMapper.find(record);
    }

    /**
     * 方法描述：根据 查询对象 查询出列表记录.
     * 创建时间：2019-06-28 14:38:31
     * 创建作者：刘万琼
     *
     * @param record 查询对象
     */
    public List<CompanyInfo> list(CompanyInfo record) {
        return companyInfoMapper.list(record);
    }

}
