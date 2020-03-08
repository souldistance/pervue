package com.songyinglong.pervue.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songyinglong.pervue.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.songyinglong.pervue.entity.UserVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-03
 */
public interface IUserService extends IService<User> {

    /**
     *
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @param userVo
     * @return
     */
    IPage<User> selectPageVo(Page<?> page, UserVO userVo);
}
