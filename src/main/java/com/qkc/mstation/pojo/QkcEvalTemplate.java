package com.qkc.mstation.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class QkcEvalTemplate implements Serializable {
    private Long id;

    private String name;

    private Integer studentType;

    private Integer studentLevel;

    private Integer pitchNumber;

    private String knwlgPoints;

    private String advise;

    private String dimensions;

    private Integer creatorId;

    private String  creatorName;

    private Date createTime;

    private static final long serialVersionUID = 1L;


}