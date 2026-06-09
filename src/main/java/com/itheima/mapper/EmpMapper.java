package com.itheima.mapper;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpExpr;
import com.itheima.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {
    //-----------------------原始分页查询-------------------------
//    查询总记录数
    /*
    @Select("select count(*) from emp left join dept on emp.dept_id = dept.id")
    public Long count();

//    分页查询
    @Select("select emp.*,dept.name deptName from emp left join dept on emp.dept_id = dept.id " +
            "order by emp.update_time desc limit #{start},#{pageSize}")
    public List<Emp> list(Integer start, Integer pageSize);
    */
//    @Select("select emp.*,dept.name deptName from emp left join dept on emp.dept_id = dept.id\n" +
//            "                                where emp.name like #{name} and gender like #{gender} and emp.entry_date between #{begin}  and #{end} \n" +
//            "                                    order by emp.update_time desc ")
//    public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);
    /**
     * 查询总记录数
     * */
    public List<Emp> list(EmpQueryParam empQueryParam);
    /**
     * 新增员工数据
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    /**
     * 批量删除员工基本数据
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 根据ID查询员工基本信息
     * 以及工作经历信息
     */
    Emp getById(Integer id);

    /**
     *根据ID更新员工数据
     */
    void updateById(Emp emp);

    /**
     * 统计各个职位的员工人数
     */
    @MapKey("pos")
    List<Map<String,Object>> countEmpJobData();

    List<Map> countEmpGenderData();
}
