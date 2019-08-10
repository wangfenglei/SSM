package com.jxau.ssm.dao;

import com.jxau.ssm.domain.Member;

/**
 * @author wfl
 * @date
 * @description
 *
 * 会员实体类
 */
public interface IMemberDao {

    /**
     * 根据Id查找会员
     * @param id
     * @return
     */
    public Member findById(String id);
}
