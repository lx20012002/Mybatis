package com.xtzyjsxy.mybatis.mapper;

import com.xtzyjsxy.mybatis.pojo.Dept;

public interface DeptMapper {
    //分布查询第二步，通过did查询员工所在部门信息
    public Dept getEmpAndDeptByStepTwo(int did);
}
