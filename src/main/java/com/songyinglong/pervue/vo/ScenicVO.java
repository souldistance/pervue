package com.songyinglong.pervue.vo;/**
 * @author SongYinglong
 * @date 2020/3/15- 2020/3/15
 */

import com.songyinglong.pervue.entity.Scenic;
import lombok.Data;

/**
 * @author Souldistance
 * 2020/3/15
 */
@Data
public class ScenicVO  extends Scenic {

    //省
    private String provinceName;
    //市
    private String cityName;
    //区
    private String districtName;

    private Integer levelId;

    private String typeName;
}
