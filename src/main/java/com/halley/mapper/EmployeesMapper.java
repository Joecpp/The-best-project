package com.halley.mapper;


import com.halley.bean.Employees;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Joe
 * @date 2020/7/19 21:05
 */
@Component
public interface EmployeesMapper {

    /**
     *  返回所有员工list
     * @return 所有员工信息
     */
    public List<Employees> getAllEmp();

    /**
     * 根据部门号返回部门下所有员工信息
     * @param deptNo
     * @return 某部门下所有员工信息
     */
    public List<Employees> getByDeptNo(Integer deptNo);

    /**
     * 根据员工号返回某一员工信息
     * @param empNo
     * @return 某一员工
     */
    public Employees getByEmpNo(Integer empNo);

    /**
     * 根据员工名、员工号、部门号多条件查询员工
     * @param empNo
     * @param empName
     * @param deptNo
     * @return 员工list
     */
    public List<Employees> getByThree(@Param("eNo") Integer empNo, @Param("eName") String empName,@Param("dNo") Integer deptNo);

    /**
     * 根据选中员工信息更新员工
     * @param emp
     * @return 是否更新成功
     */
    public boolean updateEmp(@Param("emp") Employees emp);

    /**
     * 根据选中员工号删除员工
     * @param emp
     * @return 是否删除成功
     */
    public boolean deleteEmp(Integer emp);

    /**
     * 根据编辑的员工信息添加员工
     * @param emp
     * @return 是否插入成功
     */
    public boolean addEmp(@Param("emp") Employees emp);

    /**
     * 获得姓名
     * @param deptNo
     * @return
     */
    List<String> getEmpNameByDeptNo(Integer deptNo);

    /**
     * 获得名称
     * @param empName
     * @return
     */
    Integer getEmpNoByEmpName(String empName);
}
