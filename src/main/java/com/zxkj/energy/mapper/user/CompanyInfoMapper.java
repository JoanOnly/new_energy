package com.zxkj.energy.mapper.user;

import com.zxkj.energy.pojo.user.CompanyInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CompanyInfoMapper {
    int insert(CompanyInfo record);

    int insertSelective(CompanyInfo record);

    CompanyInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CompanyInfo record);

    int updateByPrimaryKey(CompanyInfo record);

    CompanyInfo find(CompanyInfo record);

    List<CompanyInfo> list(CompanyInfo record);

    int deleteById(Long id);

    int insertBatch(@Param("insertList") List<CompanyInfo> insertList);

    int updateBatch(@Param("updateList") List<CompanyInfo> updateList);
}