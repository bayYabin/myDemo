package com.qkc.mstation.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EDZ on 2019/5/8.
 */
public class PageUtil {
    /**
     * 自定义分页静态方法
     * @param pageNo 页码
     * @param pageSize 页码数量
     * @param resultList 结果集
     * @param <T> 类型
     * @return 分过页的列表
     */
    public static <T> List<T> pageList(Integer pageNo, Integer pageSize, List<T> resultList){
        List<T> frontList = new ArrayList<>();
        if(resultList==null||resultList.size()==0){
            return frontList;
        }
        int size = resultList.size();
        int mod = size % pageSize;
        if (mod == 0) {
            pageNo = pageNo > ((size - mod) / pageSize) ? (size - mod) / pageSize : pageNo;
            for (int i = pageSize * (pageNo - 1); i < pageSize * (pageNo - 1) + pageSize; i++) {
                frontList.add(resultList.get(i));
            }
        } else {
            if (pageNo > ((size - mod) / pageSize)) {
                for (int i = 0; i < mod; i++) {
                    frontList.add(resultList.get(size - i - 1));
                }
            } else {
                for (int i = pageSize * (pageNo - 1); i < pageSize * (pageNo - 1) + pageSize; i++) {
                    frontList.add(resultList.get(i));
                }
            }
        }
        return frontList;

    }
}
