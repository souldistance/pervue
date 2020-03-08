package com.songyinglong.pervue.service.impl;

import com.songyinglong.pervue.entity.Employee;
import com.songyinglong.pervue.mapper.EmployeeMapper;
import com.songyinglong.pervue.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-03
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
