package com.songyinglong.pervue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.songyinglong.pervue.entity.MenuRole;
import com.songyinglong.pervue.mapper.MenuRoleMapper;
import com.songyinglong.pervue.service.IMenuRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements IMenuRoleService {


    @Resource
    private MenuRoleMapper menuRoleMapper;

    @Override
    public void insertBatch(Integer rid, Integer[] mids) {
        //先删除角色对应的资源
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("rid",rid);
        menuRoleMapper.delete(wrapper);

        //判断操作
        if(mids!=null && mids.length>0) {
            //遍历
            for (Integer mid : mids) {
                MenuRole menu_role = new MenuRole();
                menu_role.setMid(mid);
                menu_role.setRid(rid);
                menuRoleMapper.insert(menu_role);
            }
        }
    }
}
