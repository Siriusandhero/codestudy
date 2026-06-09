package com.itheima.mapper;

import com.itheima.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    /**
     * 批量保存员工工作经历数据
     * @param exprList
     */
    public void insertBatch(List<EmpExpr> exprList);

    /**
     * 根据员工id删除员工工作经历数据
     * @param empIds
     */
    void deleteByEmpIds(List<Integer> empIds);
}
