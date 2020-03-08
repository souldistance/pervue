package com.songyinglong.pervue.mapper;

import com.songyinglong.pervue.entity.Nation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songyinglong.pervue.entity.NationVo;

import java.util.List;

/**
 * <p>
 * 城市字典表 Mapper 接口
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-03
 */
public interface NationMapper extends BaseMapper<Nation> {

    /**
     * 查询所有的数据
     * @return
     */
    List<NationVo> findAll();

}
