package org.app.base.dao;

import org.app.base.domain.AdultVideoStar;

public interface IAdultVideoStarDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AdultVideoStar record);

    int insertSelective(AdultVideoStar record);

    AdultVideoStar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdultVideoStar record);

    int updateByPrimaryKey(AdultVideoStar record);
}