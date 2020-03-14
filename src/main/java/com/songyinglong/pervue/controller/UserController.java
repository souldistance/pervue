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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-03
 */
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

    @RequestMapping("/selectMenusByIds")
    public Result selectMenusByIds(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null){
            return Result.error(2003, "请先登录!");
        }
        return Result.ok(iUserService.selectMenusByIds(user.getId()));
    }

    @RequestMapping("/login")
    public Result login(@RequestBody User u, HttpServletRequest request){
        System.out.println(u);
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("username", u.getUsername());
        User user = iUserService.getOne(wrapper);
        System.out.println(user);
        if( user.getPassword().equals(u.getPassword())){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            return Result.ok(user);
        }else{
            return Result.error(2002, "用户名或密码错误");
        }
    }

    @RequestMapping("/logout")
    public Result logout( HttpServletRequest request){
            HttpSession session = request.getSession();
            session.invalidate();
            return Result.ok(true);
    }

}
