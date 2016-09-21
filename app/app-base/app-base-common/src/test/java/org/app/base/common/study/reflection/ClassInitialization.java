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
    
import java.lang.reflect.Proxy;
import java.util.Random;
class Initable {
        static final int staticFinal = 47;
        static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);

        static {
            System.out.println("Initializing Initable");
        }
}
class Initable2 {
        static int staticNonFinal = 147;

        static {
            System.out.println("Initializing Initable2");
        }
}
class Initable3 {
        static int staticNonFinal = 74;

        static {
            System.out.println("Initializing Initable3");
        }
}
public class ClassInitialization {

        public static Random rand = new Random(47);

        public static void main(String[] args) {
            // Does not trigger initialization
            Class initable = Initable.class;
            System.out.println("After creating Initable ref");
            // Does not trigger initialization
            System.out.println(Initable.staticFinal);
            // Does trigger initialization(rand() is static method)
            System.out.println(Initable.staticFinal2);

            // Does trigger initialization(not final)
            System.out.println(Initable2.staticNonFinal);

            try {
                Class initable3 = Class.forName("org.app.base.common.study.reflection.Initable3");
            } catch (ClassNotFoundException e) {
                System.out.println("Can't find Initable3");
                System.exit(1);
            }
            System.out.println("After creating Initable3 ref");
            System.out.println(Initable3.staticNonFinal);
            
//            final Initable2 i2 =new Initable2();
//            i2.staticNonFinal=85;
//            
//            System.out.println(Initable2.staticNonFinal);
//            i2=new Initable2();
            
        }
}