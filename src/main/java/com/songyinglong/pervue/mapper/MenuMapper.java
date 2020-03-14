package com.songyinglong.pervue.mapper;

import com.songyinglong.pervue.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-03
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 查询所有
     * @return
     */
    List<Menu> listMenus();
}
