package com.zxkj.energy.mapper.order;

import com.zxkj.energy.pojo.order.OrderInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface OrderInfoMapper {
    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    OrderInfo find(OrderInfo record);

    List<OrderInfo> list(OrderInfo record);

    int deleteById(Long id);

    int insertBatch(@Param("insertList") List<OrderInfo> insertList);

    int updateBatch(@Param("updateList") List<OrderInfo> updateList);
}