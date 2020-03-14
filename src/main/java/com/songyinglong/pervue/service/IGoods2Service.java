package com.songyinglong.pervue.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.songyinglong.pervue.entity.Goods2;
import com.songyinglong.pervue.vo.Goods2VO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Souldistance
 * @since 2020-03-13
 */
public interface IGoods2Service extends IService<Goods2> {

    Page<Goods2VO> pageVO(Page<Goods2VO> voPage, Goods2VO vo);

    boolean removeGoods(List<Integer> asList);

    boolean saveOrUpdateGoods(Goods2VO vo);
}
