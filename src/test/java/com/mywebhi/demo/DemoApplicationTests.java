package com.mywebhi.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mywebhi.demo.dao.UserMapper;
import com.mywebhi.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
class DemoApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() { }
    @Test
    public void selectList(){
        List<User> list = userMapper.selectList(null);
        System.out.println("121212");
        list.forEach(System.out::println);
        Assert.assertEquals(list.size(),6);
    }
   @Test
    public void saveUser(){
        log.info("小白白小白");
        User user = new User();
        user.setAge(18);
        user.setEmail("10000@qq.com");
        user.setName("小白");
        int i = userMapper.insert(user);
        Assert.assertEquals(i,1);
   }
   @Test
    public void updateByid(){
       User user = userMapper.selectById(5);
        user.setName("小黑");
        userMapper.updateById(user);
    }
    @Test
    public  void deleteUser(){
        int i =userMapper.deleteById(1286846025580609537L);
        Assert.assertEquals(i,1);
    }

    @Test
    public void eq(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",5L);
        User user = userMapper.selectOne(queryWrapper);
        log.info(user.toString());
    }

    @Test
    public void ne(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("id",5L);
        List<User> list = userMapper.selectList(queryWrapper);
        log.info(list.toString());
    }

    @Test
    public void gt(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age",25);
        List<User> list = userMapper.selectList(queryWrapper);
        log.info(list.toString());
    }


    @Test
    public void  selectById1(){
        User user = userMapper.selectById(5);
        log.info(user.toString());
    }

    @Test
    public void test(){

        String s = "1234567890";
        String substring = s.substring(5);
        log.info(substring);
    }


    @Test
    public void page(){
        Page<User> userPage = userMapper.selectPage(new Page<User>(1, 5), new QueryWrapper<User>().ne("id", 10));
        long size = userPage.getSize();
        log.info(String.valueOf(size));
        log.info(userPage.getRecords().toString());
    }

    @Test
    public  void  lambdaTest(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info(Thread.currentThread().getName()+"1111");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info(Thread.currentThread().getName()+"1211");
            }
        }).start();
    }

    @Test
    public void lambdaTestS(){
        new Thread(()->log.info(Thread.currentThread().getName()+"ddd")).start();
    }

    @Test
    public void testDg(){
            t(0,9);
            b(new int[]{0, 7, 9, 44},0,5);

    }

    public void t(int b, int e){
        if(b>e) return;
        else b++;log.info(String.valueOf(b));t(b, e);
    }

    public void b(int []a, int b,int e){
        int sum =0;b =0;
        int c =a.length/2;
        sum = a[c]+sum;


    }
}