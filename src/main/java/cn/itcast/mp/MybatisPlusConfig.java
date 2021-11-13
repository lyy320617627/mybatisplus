package cn.itcast.mp;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: itcast-mp-springboot
 * @description:
 * @author: ly
 * @create: 2021-11-13 18:51
 **/
@Configuration
@MapperScan("cn.itcast.mp.mapper") //设置mapper接口的扫描包
public class MybatisPlusConfig {
    @Bean//配置分页插件
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
