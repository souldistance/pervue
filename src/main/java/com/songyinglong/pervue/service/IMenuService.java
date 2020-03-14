package com.songyinglong.pervue.service;

import com.songyinglong.pervue.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-03
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 查询所有
     * @return
     */
    List<Menu> listMenus();
}
