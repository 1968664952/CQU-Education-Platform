package cn.com.chinahitech.bjmarket.user.service;

import cn.com.chinahitech.bjmarket.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhufu
 * @since 2025-06-23
 */
public interface IUserService extends IService<User> {
    List<User> getUserByName(String name);
}