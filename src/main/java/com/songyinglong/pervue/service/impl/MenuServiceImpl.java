package com.songyinglong.pervue.service.impl;

import com.songyinglong.pervue.entity.Menu;
import com.songyinglong.pervue.mapper.MenuMapper;
import com.songyinglong.pervue.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-03
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> listMenus() {
        return menuMapper.listMenus();
    }
}
