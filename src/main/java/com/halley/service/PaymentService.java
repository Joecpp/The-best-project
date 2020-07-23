package com.halley.service;

import com.halley.bean.*;
import com.halley.mapper.*;
import com.halley.utils.IntegrateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.*;

/**
 * @author Jan
 * @Date 2020/7/23 8:52
 */
@Service
public class PaymentService {
    @Autowired
    EmployeesMapper employeesMapper;

    @Autowired
    DeptMapper deptMapper;

    @Autowired
    BaseMapper baseMapper;

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    ImportMapper importMapper;

    @Autowired
    BaseRecMapper baseRecMapper;

    @Autowired
    PaymentMapper paymentMapper;

    @Transactional(rollbackFor = Exception.class)
    public Response paymentCal(String deptName, String date){
        List<PaymentForJson> paymentForJsons = new ArrayList<>();

        Response response = new Response();
        try {
            if (deptName!=null){
                Integer deptNo = deptMapper.getDeptNoByDeptName(deptName);
                List<String> empNames = employeesMapper.getEmpNameByDeptNo(deptNo);
                for (String s:empNames){
                    PaymentForJson paymentItem = getPaymentItem(s, deptName, date);
                    paymentForJsons.add(paymentItem);
                }
            }else {
                List<Dept> allDept = deptMapper.getAllDept();
                for(Dept dept:allDept){
                    String deptName1 = dept.getDeptName();
                    Integer deptNo = deptMapper.getDeptNoByDeptName(deptName1);
                    List<String> empNames = employeesMapper.getEmpNameByDeptNo(deptNo);
                    for (String s:empNames){
                        PaymentForJson paymentItem = getPaymentItem(s, deptName1,date);
                        paymentForJsons.add(paymentItem);
                    }
                }
            }
        }catch (Exception e){
            response.failure("请输入日期");
        }

        response.success(paymentForJsons);
        return response;
    }

    public PaymentForJson getPaymentItem(String empName,String deptName,String date) {
        String year = date.split("-")[0];
        String month = date.split("-")[1];

        Integer empNo = employeesMapper.getEmpNoByEmpName(empName);
        Integer deptNo = deptMapper.getDeptNoByDeptName(deptName);
        List<BaseRec> baseRecs = baseMapper.getBaseRecByDeptNo(deptNo);
        List<ImportRec> importRecs = importMapper.getImportRecByEmpNo(empNo,year,month);
        List<Item> allItem = itemMapper.getAllItem();
        HashMap<String, Double> map = new HashMap<>(5);
        double salary = 0;
        double cut = 0;
        //获得固定工资
        for (BaseRec baseRec : baseRecs) {
            Base base = baseMapper.getBaseByBaseNo(baseRec.getBaseNo());
            map.put(base.getBaseName(), baseRec.getBaseSalary());
            if (base.getFluctuat() == 1) {
                salary += baseRec.getBaseSalary();
            } else if (base.getFluctuat() == -1) {
                cut += baseRec.getBaseSalary();
            }

        }
        //导入项目
        for (ImportRec importRec : importRecs) {
            Base base = baseMapper.getBaseByBaseNo(importRec.getImportNo());
            Integer baseNo = base.getBaseNo();
            Item itemByBaseNo = itemMapper.getItemByBaseNo(baseNo);
            if (itemByBaseNo == null) {
                map.put(base.getBaseName(),importRec.getNum());
                if (base.getFluctuat() == 1) {
                    salary += importRec.getNum();
                } else if (base.getFluctuat() == -1) {
                    cut += importRec.getNum();
                }
            }
        }

        //计算项目
        for (Item item:allItem){
            String itemName = item.getItemName();
            Integer baseNo = item.getBaseNo();
            Base baseByBaseNo = baseMapper.getBaseByBaseNo(baseNo);
            if (baseByBaseNo.getFlag()==1){
                ImportRec importRecByBaseNo = importMapper.getImportRecByBaseNo(baseNo,empNo,year,month);
                if (importRecByBaseNo==null){
                    importRecByBaseNo = new ImportRec();;
                    importRecByBaseNo.setNum(0);
                }
                double num = importRecByBaseNo.getNum();
                double v = IntegrateUtil.calculation(num, item.getSecondOp(), item.getOperator());
                if (item.getFluctuat()==1){
                    salary += v;
                }else if(item.getFluctuat()==-1){
                    cut += v;
                }
                map.put(itemName,v);
            }
            else {
                BaseRec baseRecByBaseNo = baseRecMapper.getBaseRecByBaseNo(baseNo,deptNo);
                double baseSalary = baseRecByBaseNo.getBaseSalary();
                double v = IntegrateUtil.calculation(baseSalary, item.getSecondOp(), item.getOperator());
                if (item.getFluctuat()==1){
                    salary += v;
                }else if(item.getFluctuat()==-1){
                    cut += v;
                }
                map.put(itemName,v);
            }
        }

        PaymentForJson paymentForJson = new PaymentForJson();
        paymentForJson.setBaseSalary(salary);
        paymentForJson.setempNo(empNo);
        paymentForJson.setEmpName(empName);
        paymentForJson.setReallySalary(salary-cut);
        paymentForJson.setMap(map);
        for(String s: map.keySet()) {
            Item itemByItemName = itemMapper.getItemByItemName(s);
            if(null == itemByItemName){ continue;}
            ItemRec itemRec = new ItemRec();
            itemRec.setEmpNo(empNo);
            itemRec.setFlag(0);
            itemRec.setMouth(Date.valueOf(year+"-"+month+"-1"));
            itemRec.setSalary(map.get(s));
            itemRec.setItemNo(itemByItemName.getItemNo());
            if (null==paymentMapper.selectItemRec(empNo,itemByItemName.getItemNo(),year,month)){
                paymentMapper.insertItemRec(itemRec);
            }
        }
        if(paymentMapper.selectPaymentByKey(empNo,year,month)==null){
            Payment payment = new Payment();
            payment.setDate(Date.valueOf(year+"-"+month+"-1"));
            payment.setEmpNo(empNo);
            payment.setFlag(0);
            payment.setSalary(salary-cut);
            paymentMapper.insertPayment(payment);
        }
        return paymentForJson;
    }
}
