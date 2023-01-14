package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 注册用户
 *
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/1/14 11:08
 * @since JDK17
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private Integer id; //ID 主键
    private String email;   //邮箱
    private String password;    //密码， 使用md5 + 盐 加密
    private String salt;    //盐
    private String confirmCode; //确认码
    private LocalDateTime activationTime;   //激活失效时间
    private Byte isValid;   //是否可用



}
