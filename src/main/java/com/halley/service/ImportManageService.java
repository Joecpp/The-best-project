package com.halley.service;

import com.halley.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jan
 * @Date 2020/7/22 11:29
 */
@Service
public class ImportManageService {
    @Autowired
    BaseMapper baseMapper;

    public List<String> getImportName(){
        List<String> baseNameByFlag = baseMapper.getBaseNameByFlag(1);
        return baseNameByFlag;
    }
}
