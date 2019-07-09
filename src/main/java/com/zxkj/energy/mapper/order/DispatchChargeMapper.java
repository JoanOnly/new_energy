package com.zxkj.energy.mapper.order;

import com.zxkj.energy.pojo.order.DispatchCharge;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface DispatchChargeMapper {
    int insert(DispatchCharge record);

    int insertSelective(DispatchCharge record);

    DispatchCharge selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DispatchCharge record);

    int updateByPrimaryKey(DispatchCharge record);

    DispatchCharge find(DispatchCharge record);

    List<DispatchCharge> list(DispatchCharge record);

    int deleteById(Long id);

    int insertBatch(@Param("insertList") List<DispatchCharge> insertList);

    int updateBatch(@Param("updateList") List<DispatchCharge> updateList);
}