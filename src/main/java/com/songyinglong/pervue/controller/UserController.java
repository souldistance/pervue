package com.songyinglong.pervue.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songyinglong.pervue.entity.Result;
import com.songyinglong.pervue.entity.User;
import com.songyinglong.pervue.entity.UserRole;
import com.songyinglong.pervue.entity.UserVO;
import com.songyinglong.pervue.service.IUserRoleService;
import com.songyinglong.pervue.service.IUserService;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-03
 */
@Controller
@RestController
public class UserController {

    @Resource
    private IUserService iUserService;

    private IUserRoleService userRoleService;

    @RequestMapping("/list")
    public Result list(UserVO userVO,@RequestParam(defaultValue = "1") long current,
                       @RequestParam(defaultValue = "3") long size){
        Page<User> page = new Page<>(current,size);
        //自定义查询分页实现
        IPage<User> pageInfo = iUserService.selectPageVo(page, userVO);

        return Result.ok(pageInfo);
    }

    @RequestMapping("/delete")
    public Result delete(Integer []ids) {
        boolean result=iUserService.removeByIds(Arrays.asList(ids));
        return Result.ok(result);
    }

    @RequestMapping("/insertOrupdate")
    public Result insert(@RequestBody User user) {
        boolean result=iUserService.saveOrUpdate(user);
        //boolean result=iUserService.save(user);
        return Result.ok(result);
    }
}
