package com.halley.mapper;

import com.halley.bean.Dept;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Joe
 * @date 2020/7/19 21:04
 */
@Component
public interface DeptMapper {

    /**
     * 查询所有部门
     * @return 返回所有部门的封装list对象
     */
    public List<Dept> getAllDept();

    /**
     * 部门编号返回部门
     * @param deptNo 部门编号
     * @return 返回编号对应的部门
     */
    public Dept getByNo(Integer deptNo);

    /**
     * 根据部门名和部门编号返回部门，两参数为null则查询全部部门
     * @param deptNo
     * @param deptName
     * @return 返回封装的部门list
     */
    public List<Dept> getByNameAndNo(@Param("deptNo") Integer deptNo, @Param("deptName") String deptName);

    /**
     * 根据部门信息增加部门
     * @param dept
     * @return 是否正确插入
     */
    public boolean addDept(@Param("dept") Dept dept);

    /**
     * 根据新部门信息更新部门
     * @param dept
     * @return 是否正确更新
     */
    public boolean updateDept(@Param("dept") Dept dept);

    /**
     * 根据部门号删除部门
     * @param deptNo
     * @return 是否正确删除
     */
    public boolean deleteDept(@Param("deptNo")Integer deptNo);
}
