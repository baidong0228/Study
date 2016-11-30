/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */
package org.app.base.service;


import org.app.base.domain.AdultVideoStar;

import java.util.List;

public interface IAdultVideoStarService {
    public AdultVideoStar selectByPrimaryKey(Integer id);

    List<AdultVideoStar> selectAll();
}
  