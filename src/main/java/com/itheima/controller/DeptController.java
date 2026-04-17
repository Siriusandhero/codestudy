package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
//    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping("/depts")
    public Result list() {
        System.out.println("查询全部部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }
    @DeleteMapping("/depts")
    public Result delete(Integer id) {
        System.out.println("删除部门"+ id);
        deptService.deleteById(id);
        return Result.success();
    }


    /*
    * 新增部门
    * josn格式的键名名要和实体类里对象的属性对应，并添加@Requestbody注解*/
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept) {
        System.out.println("新增部门"+ dept);
        deptService.add(dept);
        return Result.success();
    }

    /*
    * 修改部门
    * 查询回显：根据ID 查询部门数据
    * @PathVariable
     */
//    @GetMapping("/depts/{id}")
//    public Result getInfo(@PathVariable("id") Integer deptId) {
//        System.out.println("查询部门ID为"+ deptId);
//        Dept dept = deptService.getInfo(deptId);
//        return Result.success(dept);
//    }
//   路径参数和形参一致可以省略（“”）
    @GetMapping("/depts/{id}")
    public Result getInfo(@PathVariable Integer id) {
        System.out.println("查询部门ID为"+ id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    /*
    * 修改部门
    * @RequestBody
     */
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept) {
        System.out.println("修改部门"+ dept);
        deptService.update(dept);
        return Result.success();
    }
}

