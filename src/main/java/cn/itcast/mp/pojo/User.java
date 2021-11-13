package cn.itcast.mp.pojo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_user")
public class User {
    @TableId(type = IdType.AUTO)
private Long id;
private String userName;
@TableField(select = false)//查询时不返回数据的值
private String password;
private String name;
private Integer age;
    @TableField(value="email")//指定数据库中的字段名
private String mail;
    @TableField(exist = false)
    private String address;//在数据库表中是不存在的
}