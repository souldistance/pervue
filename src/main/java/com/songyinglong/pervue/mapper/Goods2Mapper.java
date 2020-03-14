package com.songyinglong.pervue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songyinglong.pervue.entity.Goods2;
import com.songyinglong.pervue.vo.Goods2VO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Souldistance
 * @since 2020-03-13
 */
public interface Goods2Mapper extends BaseMapper<Goods2> {

    Page<Goods2VO> pageVO(Page<Goods2VO> voPage, Goods2VO vo);
}
