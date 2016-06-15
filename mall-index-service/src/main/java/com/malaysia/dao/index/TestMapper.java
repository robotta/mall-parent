package com.malaysia.dao.index;

import com.malaysia.entity.Test;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/5/6.
 */
@Repository
public interface TestMapper {
    /**
     * 根据主键查询
     */
    public Test getTestById(@Param("id")Integer id);

    /**
     * 查询出所有记录
     */
    public List<Test> findAllTest();

    /**
     * 保存
     */
    public int saveTest(Test test);

    /**
     * 根据主键更新（参数对象中的主键将作为更新条件）
     */
    public int updateTest(Test test);

    /**
     * 根据主键删除
     */
    public int deleteTest(@Param("id")Integer id);
}
