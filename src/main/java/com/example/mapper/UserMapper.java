package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/1/14 11:21
 * @since JDK17
 */

public interface UserMapper {

    /**
     * 账号添加
     * @param user  用户
     * @return  返回插入的用户数量
     */
    @Insert("INSERT INTO user(email, password, salt, confirm_code, activation_time, is_valid)" +
            "VALUES(#{email}, #{password}, #{salt}, #{confirmCode}, #{activationTime}, #{isValid}) ")
    int insertUser(User user);


    /**
     * 根据确认码查询用户
     * @param confirmCode   确认码
     * @return  返回与当前确认码对应的用户
     */
    @Select("SELECT email, activation_time FROM user WHERE confirm_code=#{confirmCode} AND is_valid=0")
    User selectUserByConfirmCode(@Param("confirmCode") String confirmCode);


    /**
     * 根据确认码查询用户并修改状态是为1，（1表示可用）
     * @param confirmCode   确认码
     * @return  修改的记录行数
     */
    @Update("UPDATE user SET is_valid = 1 WHERE confirm_code = {confirmCode}")
    int updateUserByConfirmCode(@Param("confirmCode") String confirmCode);


    /**
     * 查询邮箱查询用户
     * @param email 邮箱号
     * @return  返回一系列邮箱号相同的用户
     */
    @Select("SELECT email, password, salt FROM user WHERE email = #{email} AND is_valid = 1")
    List<User> selectUserByEmail(@Param("email") String email);


}
