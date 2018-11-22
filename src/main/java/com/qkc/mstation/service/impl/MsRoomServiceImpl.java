package com.qkc.mstation.service.impl;

import com.qkc.mstation.dao.MsRoomMapper;
import com.qkc.mstation.pojo.MsRoom;
import com.qkc.mstation.service.MsRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by qukoucai001 on 2018/11/22.
 */
@Service("MsRoomService")
public class MsRoomServiceImpl implements MsRoomService {


    @Autowired
    MsRoomMapper msRoomMapper;

    @Override
    public MsRoom selectByPrimaryKey(Long id) {
        return msRoomMapper.selectByPrimaryKey(id);
    }
}
