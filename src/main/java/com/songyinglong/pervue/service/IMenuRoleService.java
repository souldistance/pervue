package com.songyinglong.pervue.service;

import com.songyinglong.pervue.entity.MenuRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-03
 */
public interface IMenuRoleService extends IService<MenuRole> {

    void insertBatch(Integer rid, Integer[] mids);
}
