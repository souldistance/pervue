package com.songyinglong.pervue.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songyinglong.pervue.entity.Scenic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.songyinglong.pervue.vo.ScenicVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-15
 */
public interface IScenicService extends IService<Scenic> {

    IPage<ScenicVO> selectPageVo(Page<Scenic> page, Scenic scenic);
}
