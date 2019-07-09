package com.zxkj.energy.mapper.car;

import com.zxkj.energy.pojo.car.CarArchives;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CarArchivesMapper {
    int insert(CarArchives record);

    int insertSelective(CarArchives record);

    CarArchives selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CarArchives record);

    int updateByPrimaryKey(CarArchives record);

    CarArchives find(CarArchives record);

    List<CarArchives> list(CarArchives record);

    int deleteById(Long id);

    int insertBatch(@Param("insertList") List<CarArchives> insertList);

    int updateBatch(@Param("updateList") List<CarArchives> updateList);
}