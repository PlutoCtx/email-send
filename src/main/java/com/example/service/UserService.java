package com.example.service;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import com.example.mapper.UserMapper;
import com.example.pojo.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户服务
 *
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/1/14 11:44
 * @since JDK17
 */

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;


    /**
     * 注册账号
     * @param user
     * @return
     */
    @Transactional
    public Map<String, Object> createAccount(User user){
        // 雪花算法生成确认码
        String confirmCode = IdUtil.getSnowflake(1, 1).nextIdStr();
        //盐
        String salt = RandomUtil.randomString(6);
        // 加密密码：原始密码 + 盐
        String md5Pwd = SecureUtil.md5(user.getPassword() + salt);
        // 激活失效时间：24小时
        LocalDateTime ldt = LocalDateTime.now().plusDays(1);
        // 初始化账号信息
        user.setSalt(salt);
        user.setPassword(md5Pwd);
        user.setConfirmCode(confirmCode);
        user.setActivationTime(ldt);
        user.setIsValid((byte) 0);
        // 新增账号
        int result = userMapper.insertUser(user);
        Map<String, Object> resultMap = new HashMap<>();
        if (result > 0){
            // TODO 发送邮件
            resultMap.put("code", 200);
            resultMap.put("message", "注册成功，请前往邮箱进行账号激活");
        }else {
            resultMap.put("code", 400);
            resultMap.put("message", "注册失败");
        }
        return resultMap;

    }



    public Map<String, Object> loginAccount(User user){
        Map<String, Object> resultMap = new HashMap<>();
        // 根据邮箱查询用户
        List<User> userList = userMapper.selectUserByEmail(user.getEmail());
        // 查询不到结果，返回：该账户不存在或未激活
        if (userList == null || userList.isEmpty()){
            resultMap.put("code", 400);
            resultMap.put("message", "该账户不存在或未激活");
            return resultMap;
        }

        // 查询到多个用户，返回：账号异常，请联系管理员
        if (userList.size() > 1){
            resultMap.put("code", 400);
            resultMap.put("message", "账号异常，请联系管理员");
            return resultMap;
        }

        // 查询到一个用户，进行密码比对
        User u = userList.get(0);
        //用户输入的密码和盐进行加密
        String md5Pwd = SecureUtil.md5(u.getPassword() + u.getSalt());
        // 密码不一致，返回：用户名或密码错误
        if (!u.getPassword().equals(md5Pwd)){
            resultMap.put("code", 400);
            resultMap.put("message", "用户名或密码错误");
            return resultMap;
        }
        resultMap.put("code", 200);
        resultMap.put("message", "登录成功");
        return resultMap;

    }




}
