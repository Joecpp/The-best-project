package com.halley.bean;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jan
 * @Date 2020/7/21 23:15
 */
public class BaseForJson {
    private String empName;
    private Integer empNo;
    private String baseName;
    private double baseSalary;
    private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    private Map map;

    @Override
    public String toString() {
        return "BaseForJson{" +
                "empName='" + empName + '\'' +
                ", empNo=" + empNo +
                ", baseName='" + baseName + '\'' +
                ", baseSalary=" + baseSalary +
                ", map=" + map +
                '}';
    }

    public static List<BaseForJson> Normalization(List<BaseForJson> list){
        List<BaseForJson> baseForJsons = new ArrayList<>();
        int len = list.size();

        for (int i=0;i<len;i++){
            BaseForJson bFJ = new BaseForJson();
            if(list.size()==0){
                break;
            }
            BaseForJson b = list.get(0);
            String empName = b.getEmpName();
            Integer empNo = b.getEmpNo();
            bFJ.setDeptName(b.getDeptName());
            bFJ.setEmpName(empName);
            bFJ.setEmpNo(empNo);
            Map map = new HashMap(5);
            map.put(b.baseName,b.baseSalary);
            for(int j=1;j<list.size();j++){
                if(list.get(j).getEmpNo().equals(b.getEmpNo())){
                    map.put(list.get(j).getBaseName(),list.get(j).getBaseSalary());
                    list.remove(list.get(j));
                }
            }
            bFJ.setMap(map);
            list.remove(0);
            baseForJsons.add(bFJ);
        }
        return baseForJsons;

    }
    public BaseForJson() {
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public BaseForJson(String empName, Integer empNo, String baseName, double baseSalary,String deptName) {
        this.empName = empName;
        this.empNo = empNo;
        this.baseName = baseName;
        this.baseSalary = baseSalary;
        this.deptName = deptName;
    }
}
