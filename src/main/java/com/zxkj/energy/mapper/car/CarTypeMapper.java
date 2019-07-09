package com.zxkj.energy.mapper.car;

import com.zxkj.energy.pojo.car.CarType;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CarTypeMapper {
    int insert(CarType record);

    int insertSelective(CarType record);

    CarType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CarType record);

    int updateByPrimaryKey(CarType record);

    CarType find(CarType record);

    List<CarType> list(CarType record);

    int deleteById(Long id);

    int insertBatch(@Param("insertList") List<CarType> insertList);

    int updateBatch(@Param("updateList") List<CarType> updateList);
}