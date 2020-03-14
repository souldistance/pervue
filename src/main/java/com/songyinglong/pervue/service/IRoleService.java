package com.songyinglong.pervue.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songyinglong.pervue.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.songyinglong.pervue.vo.RoleVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-03
 */
public interface IRoleService extends IService<Role> {

    IPage<RoleVO> selectPageVo(Page<RoleVO> page, RoleVO role);

    boolean deleteByIds(Integer[] ids);

    boolean deleteRoles(Integer[] ids);
}
