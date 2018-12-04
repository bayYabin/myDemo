package com.qkc.mstation.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.qkc.mstation.pojo.QkcEvalTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface QkcEvalTemplateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(QkcEvalTemplate record);

    int insertSelective(QkcEvalTemplate record);

    QkcEvalTemplate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QkcEvalTemplate record);

    int updateByPrimaryKey(QkcEvalTemplate record);

    PageList<QkcEvalTemplate> findListByConditions(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("studentType") Integer studentType,
            @Param("studentLevel") Integer studentLevel,
            @Param("pitchNumber") Integer pitchNumber,
            @Param("creatorId") Integer creatorId,
            @Param("startTime") Date startTime,
            @Param("endTime") Date endTime,
            PageBounds pageBounds);

    List<QkcEvalTemplate> listAll(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("studentType") Integer studentType,
            @Param("studentLevel") Integer studentLevel,
            @Param("pitchNumber") Integer pitchNumber,
            @Param("creatorId") Integer creatorId,
            @Param("startTime") Date startTime,
            @Param("endTime") Date endTime);
}