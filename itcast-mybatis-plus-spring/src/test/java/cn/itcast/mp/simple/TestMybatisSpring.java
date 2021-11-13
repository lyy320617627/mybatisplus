package cn.itcast.mp.simple;

import cn.itcast.mp.simple.mapper.UserMapper;
import cn.itcast.mp.simple.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;

/**
 * @program: itcast-mybatis-plus
 * @description:
 * @author: ly
 * @create: 2021-11-13 13:35
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestMybatisSpring {
    @Autowired
    private UserMapper userMapper;

        @Test
        public void testSelectList(){
            List<User> users = this.userMapper.selectList(null);
            for (User user : users) {
                System.out.println(user);

            }
        }
}
