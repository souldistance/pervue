package com.songyinglong.pervue.vo;/**
 * @author SongYinglong
 * @date 2020/3/10- 2020/3/10
 */

import com.songyinglong.pervue.entity.Menu;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Souldistance
 * 2020/3/10
 */
@Data
public class MenuVO extends Menu implements Serializable {

    private Integer uid;
}
