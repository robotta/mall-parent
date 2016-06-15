package com.malaysia.service;

import com.malaysia.entity.Test;

import java.util.List;

/**
 * Created by Administrator on 2016/5/6.
 */
public interface TestService {
    public List<Test> findByTestList();

    public Test getMemberById(Integer id);
}
