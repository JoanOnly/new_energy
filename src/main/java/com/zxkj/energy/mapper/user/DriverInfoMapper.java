package com.zxkj.energy.mapper.user;

import com.zxkj.energy.pojo.user.DriverInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface DriverInfoMapper {
    int insert(DriverInfo record);

    int insertSelective(DriverInfo record);

    DriverInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DriverInfo record);

    int updateByPrimaryKey(DriverInfo record);

    DriverInfo find(DriverInfo record);

    List<DriverInfo> list(DriverInfo record);

    int deleteById(Long id);

    int insertBatch(@Param("insertList") List<DriverInfo> insertList);

    int updateBatch(@Param("updateList") List<DriverInfo> updateList);
}