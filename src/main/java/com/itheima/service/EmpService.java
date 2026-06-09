package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface EmpService {
//    PageResult<Emp> page(Integer page, Integer pageSize ,String name , Integer gender,
//                         LocalDate begin,
//                         LocalDate end);
    /*
    分页查询
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    /*
    保存添加员工数据
     */
    void save(Emp emp);

    void delete(List<Integer> ids);

    Emp getInfo(Integer id);

    void update(Emp emp);
}
