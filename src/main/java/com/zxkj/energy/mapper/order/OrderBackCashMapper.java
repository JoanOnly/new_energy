package com.zxkj.energy.mapper.order;

import com.zxkj.energy.pojo.order.OrderBackCash;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface OrderBackCashMapper {
    int insert(OrderBackCash record);

    int insertSelective(OrderBackCash record);

    OrderBackCash selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderBackCash record);

    int updateByPrimaryKey(OrderBackCash record);

    OrderBackCash find(OrderBackCash record);

    List<OrderBackCash> list(OrderBackCash record);

    int deleteById(Long id);

    int insertBatch(@Param("insertList") List<OrderBackCash> insertList);

    int updateBatch(@Param("updateList") List<OrderBackCash> updateList);
}