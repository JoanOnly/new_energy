package com.zxkj.energy.mapper.car;

import com.zxkj.energy.pojo.car.CarDriver;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CarDriverMapper {
    int insert(CarDriver record);

    int insertSelective(CarDriver record);

    CarDriver selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CarDriver record);

    int updateByPrimaryKey(CarDriver record);

    CarDriver find(CarDriver record);

    List<CarDriver> list(CarDriver record);

    int deleteById(Long id);

    int insertBatch(@Param("insertList") List<CarDriver> insertList);

    int updateBatch(@Param("updateList") List<CarDriver> updateList);
}