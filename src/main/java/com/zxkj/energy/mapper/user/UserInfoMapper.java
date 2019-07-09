package com.zxkj.energy.mapper.user;

import com.zxkj.energy.pojo.user.UserInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserInfoMapper {
    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    UserInfo find(UserInfo record);

    List<UserInfo> list(UserInfo record);

    int deleteById(Long id);

    int insertBatch(@Param("insertList") List<UserInfo> insertList);

    int updateBatch(@Param("updateList") List<UserInfo> updateList);
}