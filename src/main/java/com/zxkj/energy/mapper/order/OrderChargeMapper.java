package com.zxkj.energy.mapper.order;

import com.zxkj.energy.pojo.order.OrderCharge;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface OrderChargeMapper {
    int insert(OrderCharge record);

    int insertSelective(OrderCharge record);

    OrderCharge selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderCharge record);

    int updateByPrimaryKey(OrderCharge record);

    OrderCharge find(OrderCharge record);

    List<OrderCharge> list(OrderCharge record);

    int deleteById(Long id);

    int insertBatch(@Param("insertList") List<OrderCharge> insertList);

    int updateBatch(@Param("updateList") List<OrderCharge> updateList);
}