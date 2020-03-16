package com.songyinglong.pervue.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songyinglong.pervue.entity.Level;
import com.songyinglong.pervue.entity.Result;
import com.songyinglong.pervue.entity.Scenic;
import com.songyinglong.pervue.service.IScenicService;
import com.songyinglong.pervue.vo.LevelVO;
import com.songyinglong.pervue.vo.ScenicVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-15
 */
@RestController
@RequestMapping("/scenic")
public class ScenicController {

    @Resource
    private IScenicService scenicService;

    /**
     *  查询全部 等级 枚举
     * @return
     */
    @RequestMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") Integer current , @RequestParam(defaultValue = "6") Integer size, @RequestBody ScenicVO scenic){
        Page<Scenic> page = new Page<>(current,size);
        return Result.ok(scenicService.selectPageVo(page, scenic));
    }


    /**
     *  查询全部 等级 枚举
     * @return
     */
    @RequestMapping("/levels")
    public Result levels(){
        List<LevelVO> levels=new ArrayList<>();
        for (Level level : Level.values()) {
            LevelVO levelVO = new LevelVO();
            levelVO.setOrdinal(level.getOrdinal());
            levelVO.setDisplayName(level.getDisplayName());
            levels.add(levelVO);
        }
        return Result.ok(levels);
    }

    /**
     * @Description 批量删除商品
     * @Param       [ids]
     * @Date        2020/3/13
     * @Time        20:38
     */
    @RequestMapping("delScenics")
    public Result delUser(Integer[] ids) {
        return Result.ok(scenicService.removeByIds(Arrays.asList(ids)));
    }
}
