package com.songyinglong.pervue.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songyinglong.pervue.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songyinglong.pervue.entity.UserVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-03
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     *
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @param userVo
     * @return
     */
    IPage<User> selectPageVo(Page<?> page,@Param("userVo") UserVO userVO);
}
