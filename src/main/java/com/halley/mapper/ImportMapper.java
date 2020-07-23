package com.halley.mapper;

import com.halley.bean.Base;
import com.halley.bean.ImportForJson;
import com.halley.bean.ImportRec;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jan
 * @Date 2020/7/22 12:12
 */
@Repository
public interface ImportMapper {
    /**
     * get
     * @param importRec
     * @return
     */
    List<ImportRec> getAllImportRec(ImportForJson importRec);

    /**
     * 插入
     * @param importRec
     */
    void insertImportRec(ImportRec importRec);

    /**
     * 查出某人的所有导入项目
     * @param empNo
     * @param year
     * @param month
     * @return
     */
    List<ImportRec> getImportRecByEmpNo(Integer empNo, String year, String month);

    /**
     * 获得导入项目
     * @param baseNo
     * @param empNo
     * @param year
     * @param month
     * @return
     */
    ImportRec getImportRecByBaseNo(Integer baseNo,Integer empNo, String year, String month);

    /**
     * 升级啦
     * @param importRec
     */
    void updateImportRec(@Param("imp") ImportRec importRec);

}
