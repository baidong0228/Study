package org.app.base.domain;

import java.util.Date;

/**
 * This class is used for ...
 *
 * @author Bdong
 * @version 1.0, 2016年9月25日 下午8:31:10
 */
public class LoginBad {
    private int Count;
    private Date lastDate;

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }
}
