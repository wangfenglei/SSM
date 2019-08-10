package com.jxau.ssm.service;

import com.jxau.ssm.domain.SysLog;

import java.util.List;

public interface ISysLogService {


    /**
     * 保存日志
     * @param sysLog
     * @throws Exception
     */
    public void save(SysLog sysLog) throws Exception;


    /**
     * 查询日志
     * @return
     * @throws Exception
     */
    List<SysLog> findAll(int page,int size) throws Exception;

    /**
     * 清空日志
     * @throws Exception
     */
    public void delLog()throws Exception;
}
