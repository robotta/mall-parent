package com.malaysia.service.impl.index;

import com.malaysia.dao.index.TestMapper;
import com.malaysia.entity.Test;
import com.malaysia.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/5/6.
 */

@Service(value="testService")
public class TestServiceImp implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> findByTestList() {
        return testMapper.findAllTest();
    }

    @Override
    public Test getMemberById(Integer id) {
        return testMapper.getTestById(id);
    }
}
