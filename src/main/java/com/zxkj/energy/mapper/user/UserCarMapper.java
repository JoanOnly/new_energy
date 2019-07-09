package com.zxkj.energy.mapper.user;

import com.zxkj.energy.pojo.user.UserCar;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserCarMapper {
    int insert(UserCar record);

    int insertSelective(UserCar record);

    UserCar selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserCar record);

    int updateByPrimaryKey(UserCar record);

    UserCar find(UserCar record);

    List<UserCar> list(UserCar record);

    int deleteById(Long id);

    int insertBatch(@Param("insertList") List<UserCar> insertList);

    int updateBatch(@Param("updateList") List<UserCar> updateList);
}