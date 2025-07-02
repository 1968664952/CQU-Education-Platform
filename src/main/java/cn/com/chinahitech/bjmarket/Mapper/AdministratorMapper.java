package cn.com.chinahitech.bjmarket.Mapper;

import cn.com.chinahitech.bjmarket.entity.Administrator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdministratorMapper {
    @Select("SELECT * FROM administrators WHERE administrator_id = #{id}")
    Administrator findById(@Param("id") String administratorId);
}
