package com.songyinglong.pervue.entity;/**
 * @author SongYinglong
 * @date 2020/3/5- 2020/3/5
 */

import lombok.Data;

/**
 * @author Souldistance
 * 2020/3/5
 */
@Data
public class UserVO extends  User{
    //省
    private String provinceName;
    //市
    private String cityName;
    //区
    private String districtName;

    //扩展角色表的属性
    private String rids;
    private String rnames;
    private String rnameZhs;
}
