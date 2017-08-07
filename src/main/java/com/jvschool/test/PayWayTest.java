package com.jvschool.test;


import com.jvschool.svc.Impl.PayWayServiceImpl;
import com.jvschool.svc.PayWayService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PayWayTest {
//
//    @Configuration
//    static class AccountServiceTestContextConfiguration {
//        @Bean
//        public PayWayService payWayService() {
//            return new PayWayServiceImpl();
//        }
//    }
//
//    @Autowired
//    private PayWayService pws;
//    //@Before
//    //public void prepare() { pws = new PayWayServiceImpl();}
//
//    @Test
//    public void countPayWays(){ assertEquals(2 , pws.getAllPayWays().size());}
//
//

}
