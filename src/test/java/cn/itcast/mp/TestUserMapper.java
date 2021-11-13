package cn.itcast.mp;

import cn.itcast.mp.mapper.UserMapper;
import cn.itcast.mp.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.corba.se.impl.orbutil.ObjectStreamClassUtil_1_3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Test
    public void testDeleteById(){
        //根据id删除我们的数据
        int i = this.userMapper.deleteById(9);
        System.out.println(i);
    }
    @Test
    public void testDeleteByMap(){
        Map<String,Object> map=new HashMap<>();
        map.put("user_name","zhangsan");
        map.put("password","999999");
        int result=this.userMapper.deleteByMap(map);
        //根据map删除数据，多条件之间是and关系
        System.out.println(result);
    }
    @Test
    public void testDelete(){
//        //用法一：
//        QueryWrapper<User> wrapper=new QueryWrapper<>();
//        wrapper.eq("user_name","caocao1").eq("password","123456");
        //用法二
        User user=new User();
        user.setPassword("123456");
        user.setUserName("caocao1");
        QueryWrapper<User> wrapper=new QueryWrapper<>(user);
        //根据我们包装的条件进行删除
        int delete = this.userMapper.delete(wrapper);
        System.out.println("delete=>"+delete);
    }
    @Test
    public void testDeleteBatchIds(){
        //根据id批量删除数据
        int i = this.userMapper.deleteBatchIds(Arrays.asList(10L, 11L));
        System.out.println(i);
    }
    @Test
    public void testSelectById(){
        User user = this.userMapper.selectById(2L);
        System.out.println(user);
    }
    @Test
    public void testSelectBatchlds(){
        //根据id批量查询数据
        List<User> users = this.userMapper.selectBatchIds(Arrays.asList(2L, 3L));
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testSelectOne(){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        //设置查询条件
        wrapper.eq("password","123456");
        //查询的数据超出一条时，会抛出异常
        User user = this.userMapper.selectOne(wrapper);
        System.out.println(user);
    }
    @Test
    public void testSelectCount(){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.gt("age",20);//条件：年龄大于20岁的用户
        //根据条件，查询数据的条数
        Integer integer = this.userMapper.selectCount(wrapper);
        System.out.println(integer);
    }
    @Test
    public void testSelectList(){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
     //设置查询条件
        wrapper.like("email","itcast");
        List<User> users = this.userMapper.selectList(wrapper);
        for (User user : users) {
            System.out.println(user);

        }
    }
    //测试分页查询
    @Test
    public void testSelectPage(){
        Page<User> page=new Page<>(1,1);
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        //设置查询条件
        wrapper.like("email","itcast");
        IPage<User> iPage=this.userMapper.selectPage(page,wrapper);
        System.out.println("数据总条数："+iPage.getTotal());
        System.out.println("数据总页数"+iPage.getPages());
        System.out.println("当前页数"+iPage.getCurrent());
        List<User> records = iPage.getRecords();
        for (User record : records) {
            System.out.println(record);
        }
    }
    @Test
    public void testFindById(){
        User byId = this.userMapper.findById(2L);
        System.out.println(byId);
    }
}
