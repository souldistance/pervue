package com.songyinglong.pervue.service.impl;

import com.songyinglong.pervue.entity.Test;
import com.songyinglong.pervue.mapper.TestMapper;
import com.songyinglong.pervue.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-08
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

}
