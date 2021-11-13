package cn.itcast.mp.simple;

import cn.itcast.mp.simple.mapper.UserMapper;
import cn.itcast.mp.simple.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @program: itcast-mybatis-plus
 * @description:
 * @author: ly
 * @create: 2021-11-13 11:30
 **/

public class TestMybatis {
    @Test
    public void testFindAll() throws IOException {
        String config="mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(config);
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //测试查询
        List<User> all = userMapper.findAll();
        for (User user:all){
            System.out.println(user);
        }
    }
}
