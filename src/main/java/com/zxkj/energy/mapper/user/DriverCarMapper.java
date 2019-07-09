package com.zxkj.energy.mapper.user;

import com.zxkj.energy.pojo.user.DriverCar;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface DriverCarMapper {
    int insert(DriverCar record);

    int insertSelective(DriverCar record);

    DriverCar selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DriverCar record);

    int updateByPrimaryKey(DriverCar record);

    DriverCar find(DriverCar record);

    List<DriverCar> list(DriverCar record);

    int deleteById(Long id);

    int insertBatch(@Param("insertList") List<DriverCar> insertList);

    int updateBatch(@Param("updateList") List<DriverCar> updateList);
}