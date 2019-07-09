package com.zxkj.energy.mapper.order;

import com.zxkj.energy.pojo.order.DispatchTrack;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface DispatchTrackMapper {
    int insert(DispatchTrack record);

    int insertSelective(DispatchTrack record);

    DispatchTrack selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DispatchTrack record);

    int updateByPrimaryKey(DispatchTrack record);

    DispatchTrack find(DispatchTrack record);

    List<DispatchTrack> list(DispatchTrack record);

    int deleteById(Long id);

    int insertBatch(@Param("insertList") List<DispatchTrack> insertList);

    int updateBatch(@Param("updateList") List<DispatchTrack> updateList);
}