package com.songyinglong.pervue.service.impl;

import com.songyinglong.pervue.entity.Nation;
import com.songyinglong.pervue.entity.NationVo;
import com.songyinglong.pervue.mapper.NationMapper;
import com.songyinglong.pervue.service.INationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 城市字典表 服务实现类
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-03
 */
@Service
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {

    @Resource
    private NationMapper nationMapper;


    @Override
    @Cacheable(cacheNames = {"my-redis-cache1"})
    public List<NationVo> findAll() {
        return nationMapper.findAll();
    }
}
