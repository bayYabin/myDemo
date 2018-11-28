package com.qkc.mstation.controller;

import com.qkc.mstation.common.model.ApiResult;
import com.qkc.mstation.pojo.MsRoom;
import com.qkc.mstation.service.MsRoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qukoucai001 on 2018/11/22.
 */
@RestController
@RequestMapping("/room")
public class MsRoomController {

    private static final Logger logger = LoggerFactory.getLogger(MsRoomController.class);

    @Autowired
    private MsRoomService msRoomService;


    /**
     * 测试
     * @param pageSize
     * @param pageNo
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ApiResult selectAll(Integer pageSize, Integer pageNo){
        logger.info("测试接口开始:参数-->,pageSize:"+pageSize+",pageNo:"+pageNo);
        if(pageNo == null){
            pageNo = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }

        return ApiResult.ok(666);
    }
}
