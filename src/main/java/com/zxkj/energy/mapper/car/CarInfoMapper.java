package com.zxkj.energy.mapper.car;

import com.zxkj.energy.pojo.car.CarInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CarInfoMapper {
    int insert(CarInfo record);

    int insertSelective(CarInfo record);

    CarInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CarInfo record);

    int updateByPrimaryKey(CarInfo record);

    CarInfo find(CarInfo record);

    List<CarInfo> list(CarInfo record);

    int deleteById(Long id);

    int insertBatch(@Param("insertList") List<CarInfo> insertList);

    int updateBatch(@Param("updateList") List<CarInfo> updateList);
}