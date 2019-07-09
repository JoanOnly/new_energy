package com.zxkj.energy.mapper.order;

import com.zxkj.energy.pojo.order.OrderCashFlow;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface OrderCashFlowMapper {
    int insert(OrderCashFlow record);

    int insertSelective(OrderCashFlow record);

    OrderCashFlow selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderCashFlow record);

    int updateByPrimaryKey(OrderCashFlow record);

    OrderCashFlow find(OrderCashFlow record);

    List<OrderCashFlow> list(OrderCashFlow record);

    int deleteById(Long id);

    int insertBatch(@Param("insertList") List<OrderCashFlow> insertList);

    int updateBatch(@Param("updateList") List<OrderCashFlow> updateList);
}