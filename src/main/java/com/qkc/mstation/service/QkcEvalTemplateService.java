package com.qkc.mstation.service;

import com.qkc.mstation.common.model.Page;
import com.qkc.mstation.pojo.QkcEvalTemplate;

import java.util.List;

/**
 * Created by qukoucai001 on 2018/11/22.
 */
public interface QkcEvalTemplateService {

    int deleteByPrimaryKey(Long id);

    int insert(QkcEvalTemplate record);

    int insertSelective(QkcEvalTemplate record);

    QkcEvalTemplate selectByPrimaryKey(Long id);



    int updateByPrimaryKeySelective(QkcEvalTemplate record);

    int updateByPrimaryKey(QkcEvalTemplate record);
}
