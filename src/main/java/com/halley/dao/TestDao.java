package com.halley.dao;

import com.halley.bean.TestBean;

import java.util.List;

public interface TestDao {

    public List<TestBean> findAll();
}
