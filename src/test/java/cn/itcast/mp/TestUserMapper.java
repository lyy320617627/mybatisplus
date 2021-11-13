package cn.itcast.mp;

import cn.itcast.mp.mapper.UserMapper;
import cn.itcast.mp.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: itcast-mp-springboot
 * @description:
 * @author: ly
 * @create: 2021-11-13 15:07
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class TestUserMapper {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testInsert(){
        User user=new User();
        user.setMail("1@itcast.cn");
        user.setAge(301);
        user.setUserName("曹操");
        user.setName("caocao");
        user.setPassword("123456");
        user.setAddress("北京");
        int result = this.userMapper.insert(user);//result返回的是受影响的行数
        System.out.println("result=>"+result);
        //获取自增长的id值
        System.out.println("id=>"+user.getId());
    }
    @Test
    public  void selectById(){
        User user = this.userMapper.selectById(1);
        System.out.println(user);
    }
    @Test
    public void testUpdateById(){
        User user=new User();
        user.setId(1L);//条件：根据id更新
        user.setAge(19);//更新的字段
        user.setPassword("666666");
        int i = this.userMapper.updateById(user);
        System.out.println("i"+i);
    }
    @Test
    public void testUpdate(){
     User user=new User();
     user.setAge(20);
     user.setPassword("888888");
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_name","zhangsan");//根据条件匹配user_name=zhangsan
        //根据条件更新
        int update = this.userMapper.update(user, queryWrapper);
        System.out.println("update=>"+update);
    }
    @Test
    public void testUpdate2(){
        UpdateWrapper<User> queryWrapper=new UpdateWrapper<>();
        queryWrapper.set("password","999999").set("age",401)//更新的字段
                .eq("user_name","zhangsan");//更新的条件
        //根据条件更新
        int update = this.userMapper.update(null, queryWrapper);
        System.out.println("update=>"+update);
    }
}
