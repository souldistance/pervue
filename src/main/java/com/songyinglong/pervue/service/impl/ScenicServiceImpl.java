package com.songyinglong.pervue.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songyinglong.pervue.entity.Scenic;
import com.songyinglong.pervue.mapper.ScenicMapper;
import com.songyinglong.pervue.service.IScenicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songyinglong.pervue.vo.ScenicVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-15
 */
@Service
public class ScenicServiceImpl extends ServiceImpl<ScenicMapper, Scenic> implements IScenicService {

    @Resource
    private ScenicMapper scenicMapper;

    @Override
    public IPage<ScenicVO> selectPageVo(Page<Scenic> page, Scenic scenic) {
        return scenicMapper.selectPageVo(page,scenic);
    }
}
