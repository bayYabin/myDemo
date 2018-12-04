package com.qkc.mstation.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.qkc.mstation.common.model.Page;
import com.qkc.mstation.dao.MsRoomMapper;
import com.qkc.mstation.dao.QkcEvalTemplateMapper;
import com.qkc.mstation.pojo.QkcEvalTemplate;
import com.qkc.mstation.service.QkcEvalTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by qukoucai001 on 2018/11/22.
 */
@Service("qkcEvalTemplateService")
public class QkcEvalTemplateServiceImpl implements QkcEvalTemplateService {



    @Autowired
    QkcEvalTemplateMapper qkcEvalTemplateMapper;






//
    @Override
    public int deleteByPrimaryKey(Long id) {
        return qkcEvalTemplateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(QkcEvalTemplate record) {
        return qkcEvalTemplateMapper.insert(record);
    }

    @Override
    public int insertSelective(QkcEvalTemplate record) {
        return qkcEvalTemplateMapper.insertSelective(record);
    }

    @Override
    public QkcEvalTemplate selectByPrimaryKey(Long id) {
        return qkcEvalTemplateMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(QkcEvalTemplate record) {
        return qkcEvalTemplateMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(QkcEvalTemplate record) {
        return qkcEvalTemplateMapper.updateByPrimaryKey(record);
    }



}
