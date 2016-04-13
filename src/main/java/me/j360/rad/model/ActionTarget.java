package me.j360.rad.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Package: me.j360.rad.model
 * User: min_xu
 * Date: 16/4/13 下午4:53
 * 说明：
 */
public class ActionTarget {

    @Getter
    @Setter
    private long targetId;
    @Getter
    @Setter
    private String timestamp;
    @Getter
    @Setter
    private long count;
    @Getter
    @Setter
    private long nextCount;
    @Getter
    @Setter
    private long data;
}
