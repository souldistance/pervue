package com.songyinglong.pervue.entity;

import java.io.Serializable;

/**
 * @author SongYinglong
 * @date 2020/3/15- 2020/3/15
 */
public enum Level implements Serializable {

    AAAAA("5A级"),AAAA("4A级"),AAA("3A级"),AA("2A级"),A("1A级");

    private String displayName;

    public String getDisplayName() {
        return displayName;
    }

    private Integer ordinal;

    public Integer getOrdinal() {
        return ordinal;
    }

    Level(String displayName) {
        this.ordinal=this.ordinal();
        this.displayName = displayName;
    }
}
