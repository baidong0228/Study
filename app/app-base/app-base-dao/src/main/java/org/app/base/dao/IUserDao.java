package org.app.base.dao;

import org.app.base.domain.User;
import org.app.base.domain.vo.UserVO;

public interface IUserDao {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    UserVO selectByName(String username);
}