package com.songyinglong.pervue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songyinglong.pervue.entity.MenuRole;
import com.songyinglong.pervue.entity.Role;
import com.songyinglong.pervue.entity.UserRole;
import com.songyinglong.pervue.mapper.MenuRoleMapper;
import com.songyinglong.pervue.mapper.RoleMapper;
import com.songyinglong.pervue.mapper.UserRoleMapper;
import com.songyinglong.pervue.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songyinglong.pervue.vo.RoleVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-03
 */
@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private MenuRoleMapper menuRoleMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public IPage<RoleVO> selectPageVo(Page<RoleVO> page, RoleVO role) {
        return roleMapper.selectPageVo(page, role);
    }

    @Override
    public boolean deleteByIds(Integer[] ids) {
        for (Integer id : ids) {
            QueryWrapper queryWrapper = new QueryWrapper() ;
            queryWrapper.eq("rid", id);
            menuRoleMapper.delete(queryWrapper);
        }
        return roleMapper.deleteBatchIds(Arrays.asList(ids))>0;
    }

    @Override
    public boolean deleteRoles(Integer[] ids) {
        int i = 0;
        for (Integer id : ids) {
            //先删除角色-用户的
            QueryWrapper<UserRole> wrapper = new QueryWrapper<>();
            wrapper.eq("rid", id);
            userRoleMapper.delete(wrapper);
            //再删除角色-菜单的
            QueryWrapper<MenuRole> wrapper2 = new QueryWrapper<>();
            wrapper2.eq("rid", id);
            menuRoleMapper.delete(wrapper2);
            //再删除角色自己的
            i = roleMapper.deleteById(id);
        }
        return i>0;
    }
}
