package com.xtzyjsxy.mybatis.mapper;

import com.xtzyjsxy.mybatis.pojo.Emp;

import java.util.List;

public interface EmpMapper {
    public List<Emp> getAllEmp();

    //查询员工以及员工所对应的部门信息
    public Emp getEmpAndDept(int eid);

    //第一步：查询员工信息
    public Emp getEmpAndDeptByStepOne(int eid);


}
