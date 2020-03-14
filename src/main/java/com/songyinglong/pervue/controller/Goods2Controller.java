package com.songyinglong.pervue.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songyinglong.pervue.entity.Result;
import com.songyinglong.pervue.service.IGoods2Service;
import com.songyinglong.pervue.vo.Goods2VO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Souldistance
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/goods2")
public class Goods2Controller {

    @Resource
    private IGoods2Service iGoods2Service;

    /**
     * @Description 商品, 促销, 地区多表联查, 条件查询, 区间查询, 分页
     * @Param [current, vo, size]
     * @Date 2020/3/13
     * @Time 19:38
     */
    @RequestMapping("list")
    public Result list(@RequestParam(defaultValue = "1") Integer current, Goods2VO vo, @RequestParam(defaultValue = "3") Integer size) {
        Page<Goods2VO> voPage = new Page<>(current, size);
        Page<Goods2VO> page = iGoods2Service.pageVO(voPage, vo);
        return Result.ok(page);
    }

    /**
    * @Description 批量删除商品
    * @Param       [ids]
    * @Date        2020/3/13
    * @Time        20:38
    */
    @RequestMapping("delGoods")
    public Result delUser(Integer[] ids) {
        return Result.ok(iGoods2Service.removeGoods(Arrays.asList(ids)));
    }

    /**
     * @Description 保存或者修改, 由于牵扯到1个中间表,
     * @Param []
     * @Date 2020/3/13
     * @Time 21:10
     */
    @RequestMapping("saveOrUpdateGoods")
    public Result saveOrUpdateGoods(@RequestBody Goods2VO vo) {
        return Result.ok(iGoods2Service.saveOrUpdateGoods(vo));
    }

}
