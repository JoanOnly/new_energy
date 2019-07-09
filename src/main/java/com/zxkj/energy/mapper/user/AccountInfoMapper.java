package com.zxkj.energy.mapper.user;

import com.zxkj.energy.pojo.user.AccountInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AccountInfoMapper {
    int insert(AccountInfo record);

    int insertSelective(AccountInfo record);

    AccountInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AccountInfo record);

    int updateByPrimaryKey(AccountInfo record);

    AccountInfo find(AccountInfo record);

    List<AccountInfo> list(AccountInfo record);

    int deleteById(Long id);

    int insertBatch(@Param("insertList") List<AccountInfo> insertList);

    int updateBatch(@Param("updateList") List<AccountInfo> updateList);
}