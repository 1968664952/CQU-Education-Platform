package cn.com.chinahitech.bjmarket.user.controller;


import cn.com.chinahitech.bjmarket.user.entity.User;
import cn.com.chinahitech.bjmarket.user.service.IUserService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhufu
 * @since 2025-06-23
 */
import com.alibaba.fastjson.JSON;
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping(value="/getUserByName",method = RequestMethod.POST)
    public String getUserByName(String name){
        List<User> userList =null;
        Map<String,Object> map =new HashMap<String,Object>();
        try{
            userList=userService.getUserByName(name);
            map.put("status","200");
            map.put("data",userList);
        }catch(Exception ex){
            map.put("status","-1");
            map.put("errorMsg",ex.getMessage());
        }
        return JSON.toJSONString(map);
    }
}










