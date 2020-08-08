package com.mywebhi.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;

/**
 * @author: jeff
 * @date: 2020-07-27 9:10
 * @Description:
 * @version: 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class TestH {

    @Test
    public void r() {

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        log.info("sdfsdf");
                    }
                }

        ).start();

    }

    @Test
    public void t() {
        new Thread(() -> log.info("s")).start();
    }

    @Test
    public void te() {
//        Integer p1 = new TestInteface() {
//            @Override
//            public Integer p() {
//                log.info("2");
//                return 1 + 1;
//            }
//        }.p();
//        log.info(String.valueOf(p1)+"hjghj");
    }

    //    @Test
//    public void  ts(){
//        TestInteface t =((a)->5+a);
//        log.info(t.p(3).toString());
//    }
//
    @Test
    public void tf() {
        TestInteface tf = ((a, b) -> a + b);
        log.info(tf.p(7, 8).toString());
    }

    @Test
    public void timeTest() {
        String time = "2020年8月8日";
        String year = time.substring(0, 4);
        String mouth = time.substring(6, 8);
        String day = time.substring(time.length()-2,time.length()-1);
        log.info("{}年{}月{}日",year,mouth,day);

    }
}