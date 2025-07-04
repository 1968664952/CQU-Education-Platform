package cn.com.chinahitech.bjmarket.fileResources.mapper;

import cn.com.chinahitech.bjmarket.fileResources.entity.DocumentResources;
import cn.com.chinahitech.bjmarket.fileResources.entity.sDocumentResources;
import cn.com.chinahitech.bjmarket.information.entity.MID;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 * 文档资源表 Mapper 接口
 * </p>
 *
 * @author zhufu
 * @since 2025-07-04
 */
@Mapper
public interface DocumentResourcesMapper extends BaseMapper<DocumentResources> {
    //管理员用类别模糊搜索+年份，专业，年级搜索
    List<DocumentResources> showlist(String primaryCategory,String secondaryCategory,String useyear,String applicableMajor,String applicableGrade);

    //设置资源状态
    @Update("UPDATE document_resources SET status = #{status} WHERE id = #{id}")
    int updatestatus(int status,int id);

    //重设资源路径
    @Update("UPDATE document_resources SET file_path = #{filePath} WHERE id = #{id}")
    int updatefilepath(String filePath,int id);

    //插入资源
    @Insert("INSERT INTO document_resources " +
            "(title, primary_category, secondary_category, useyear, view_count, download_count, " +
            "publish_time, file_path, author_id, author_name, status, applicable_major, applicable_grade) " +
            "VALUES (#{title}, #{primaryCategory}, #{secondaryCategory}, #{useyear}, #{viewCount}, #{downloadCount}, " +
            "#{publishTime}, #{filePath}, #{authorId}, #{authorName}, #{status}, #{applicableMajor}, #{applicableGrade})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertDocumentResource(DocumentResources resource);

    //学生用类别模糊搜索+年份，专业，年级搜索
    List<sDocumentResources> s_showlist(String primaryCategory, String secondaryCategory, String useyear, String applicableMajor, String applicableGrade);

    @Select("select * from document_resources where id=#{resid}")
    DocumentResources getRes(int resid);

    @Delete("DELETE from academic_journal where id=#{resid}")
    int deleteById(String id);


}
