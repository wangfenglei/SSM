package com.jxau.ssm.dao;

import com.jxau.ssm.domain.SysLog;

import java.util.List;


/**
 *
 * 日志持久层
 */
public interface ISysLogDao {


    /**
     * 插入日志
     * @param sysLog
     * @throws Exception
     */
    public void save(SysLog sysLog) throws Exception;

    /**
     * 表查询所有日志
     * @return
     * @throws Exception
     */
    List<SysLog> findAll() throws Exception;


    /**
     * 清空日志
     * @throws Exception
     */
    public void delLog()throws Exception;
}
