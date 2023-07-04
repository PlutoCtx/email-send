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

    /**
     * ID 主键
     */
    private Integer id;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码， 使用md5 + 盐 加密
     */
    private String password;
    /**
     * 盐
     */
    private String salt;
    /**
     * 确认码
     */
    private String confirmCode;
    /**
     * 激活失效时间
     */
    private LocalDateTime activationTime;
    /**
     * 是否可用
     */
    private Byte isValid;



}
