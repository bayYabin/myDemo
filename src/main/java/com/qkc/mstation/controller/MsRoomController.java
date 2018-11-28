package com.qkc.mstation.controller;

import com.qkc.mstation.pojo.MsRoom;
import com.qkc.mstation.service.MsRoomService;
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
    @Autowired
    private MsRoomService msRoomService;

    /**
     * 获取所有的区域信息
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private Map<String, Object> listArea() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        MsRoom msRoom= msRoomService.selectByPrimaryKey(16L);
        modelMap.put("msRoom", msRoom);
        return modelMap;
    }
}
