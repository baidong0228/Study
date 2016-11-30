/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */
package org.app.base.common.study.reflection;

import java.io.IOException;

public class DynamicFactory {
    public static Games getInstance(String ClassName) {
        Games game = null;
        try {
            game = (Games) Class.forName(ClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return game;
    }

    public static void main(String[] a) throws
            IOException {
        Games game = DynamicFactory.getInstance("org.app.base.common.study.reflection.LOL");
        if (game != null) {
            game.play();
        }
    }

}
  