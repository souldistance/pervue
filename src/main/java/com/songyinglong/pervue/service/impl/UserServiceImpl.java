package com.songyinglong.pervue.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songyinglong.pervue.entity.User;
import com.songyinglong.pervue.entity.UserVO;
import com.songyinglong.pervue.mapper.UserMapper;
import com.songyinglong.pervue.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public IPage<User> selectPageVo(Page<?> page, UserVO userVo) {
        return userMapper.selectPageVo(page,userVo);
    }
}
