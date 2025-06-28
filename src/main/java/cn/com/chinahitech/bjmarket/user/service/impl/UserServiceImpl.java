package cn.com.chinahitech.bjmarket.user.service.impl;

import cn.com.chinahitech.bjmarket.user.entity.User;
import cn.com.chinahitech.bjmarket.user.mapper.UserMapper;
import cn.com.chinahitech.bjmarket.user.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhufu
 * @since 2025-06-23
 */
//alt+enter
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements
        IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override

    public List<User> getUserByName(String name) {
        List<User> userList =null;
//1)创建QueryWrapper对象
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("name",name);
//2)执行查询
        userList = userMapper.selectList(wrapper);
        return userList;
    }
}
