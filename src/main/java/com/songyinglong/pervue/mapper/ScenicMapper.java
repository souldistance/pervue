package com.songyinglong.pervue.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songyinglong.pervue.entity.Scenic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songyinglong.pervue.vo.ScenicVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-15
 */
public interface ScenicMapper extends BaseMapper<Scenic> {

    IPage<ScenicVO> selectPageVo(Page<Scenic> page,@Param("vo") Scenic scenic);
}
