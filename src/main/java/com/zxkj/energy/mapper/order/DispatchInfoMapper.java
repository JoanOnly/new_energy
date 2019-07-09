package com.zxkj.energy.mapper.order;

import com.zxkj.energy.pojo.order.DispatchInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface DispatchInfoMapper {
    int insert(DispatchInfo record);

    int insertSelective(DispatchInfo record);

    DispatchInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DispatchInfo record);

    int updateByPrimaryKey(DispatchInfo record);

    DispatchInfo find(DispatchInfo record);

    List<DispatchInfo> list(DispatchInfo record);

    int deleteById(Long id);

    int insertBatch(@Param("insertList") List<DispatchInfo> insertList);

    int updateBatch(@Param("updateList") List<DispatchInfo> updateList);
}