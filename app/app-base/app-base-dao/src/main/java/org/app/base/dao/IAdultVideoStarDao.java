package org.app.base.dao;


import org.app.base.domain.AdultVideoStar;

import java.util.List;

public interface IAdultVideoStarDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AdultVideoStar record);

    int insertSelective(AdultVideoStar record);

    AdultVideoStar selectByPrimaryKey(Integer id);
    
    List<AdultVideoStar> selectAll();

    int updateByPrimaryKeySelective(AdultVideoStar record);

    int updateByPrimaryKey(AdultVideoStar record);
}