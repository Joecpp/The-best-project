package com.halley.service;

import com.halley.bean.TestBean;
import com.halley.dao.TestDao;

import java.util.List;

/**
 * @author Jan
 * @Date 2020/7/14 11:51
 */
public class TestService {

    TestDao testDao;

    public List<TestBean> findAll(){
        List<TestBean> ls =null;
//        ls = testDao.findAll();
        return ls;
    }
}
