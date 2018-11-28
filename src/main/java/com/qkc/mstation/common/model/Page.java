package com.qkc.mstation.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by qukoucai001 on 2018/11/28.
 */
public class Page<T> implements Serializable {
    private static final long serialVersionUID = -5215301829268317718L;
    protected int num;
    protected int size;
    protected int count;
    protected int order;
    protected List<T> list;

    public Page() {
        this.num = 1;
        this.size = 20;
        this.count = -1;
        this.order = -1;
        this.list = new ArrayList();
    }

    public Page(int num, int size, List<T> list) {
        this(num, size, (Map)null, list);
    }

    public Page(int num, int size, Map<String, Integer> orders, List<T> list) {
        this.num = 1;
        this.size = 20;
        this.count = -1;
        this.order = -1;
        this.list = new ArrayList();
        if(num > 0) {
            this.num = num;
        }

        if(size > 0 && size <= 20) {
            this.size = size;
        }

        if(list != null) {
            this.list = list;
        }

    }

    public Page(Page<T> page) {
        this(page.getNum(), page.getSize(), page.list);
    }

    public static <T> Page<T> reNew(Page<?> page) {
        return new Page(page.getNum(), page.getSize(), (List)null);
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        if(num > 0) {
            this.num = num;
        }

    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getList() {
        return this.list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}