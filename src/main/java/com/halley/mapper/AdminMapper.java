package com.halley.mapper;

import com.halley.bean.Admin;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author Jan
 * @Date 2020/7/18 22:10
 */
@Component
public interface AdminMapper {
    /**
     * 获得登录用户的信息
     * @param username
     * @return
     */
    public Admin getAdminByUsername(String username);
}
