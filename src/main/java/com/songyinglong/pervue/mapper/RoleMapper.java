package com.songyinglong.pervue.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songyinglong.pervue.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songyinglong.pervue.vo.RoleVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-03
 */
public interface RoleMapper extends BaseMapper<Role> {

    IPage<RoleVO> selectPageVo(Page<RoleVO> page, @Param("vo") RoleVO role);
}
