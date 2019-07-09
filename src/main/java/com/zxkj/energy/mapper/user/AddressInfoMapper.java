package com.zxkj.energy.mapper.user;

import com.zxkj.energy.pojo.user.AddressInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AddressInfoMapper {
    int insert(AddressInfo record);

    int insertSelective(AddressInfo record);

    AddressInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AddressInfo record);

    int updateByPrimaryKey(AddressInfo record);

    AddressInfo find(AddressInfo record);

    List<AddressInfo> list(AddressInfo record);

    int deleteById(Long id);

    int insertBatch(@Param("insertList") List<AddressInfo> insertList);

    int updateBatch(@Param("updateList") List<AddressInfo> updateList);
}