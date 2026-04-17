package com.itheima.mapper;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
//    查询总记录数
    @Select("select emp.*,dept.name from emp left join dept on emp.dept_id = dept.id")
    public Long count();

//    分页查询
    @Select("select emp.*,dept.name deptName from emp left join dept on emp.dept_id = dept.id " +
            "order by emp.update_time desc limit #{start},#{pageSize}")
    public List<Emp> list(Integer start, Integer pageSize);
}
