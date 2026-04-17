package com.itheima.service.impl;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageResult;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 员工管理业务层接口实现类
 */

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public PageResult<Emp> page(@RequestParam(defaultValue = "1")  Integer page,
                                @RequestParam(defaultValue = "10") Integer pageSize) {
        //1.调用mapper接口，查询计算总数
        Long total = empMapper.count();
        //2.调用mapper接口，分页查询，查询结果列表
        Integer start = (page - 1) * pageSize;
        List<Emp> rows = empMapper.list(start, pageSize);
        //3.封装结果
        return new PageResult(total, rows);
    }
}
