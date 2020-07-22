package com.halley.mapper;

import com.halley.bean.Base;
import com.halley.bean.ImportForJson;
import com.halley.bean.ImportRec;
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
}
