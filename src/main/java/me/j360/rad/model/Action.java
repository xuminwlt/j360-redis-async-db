package me.j360.rad.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Package: me.j360.rad.model
 * User: min_xu
 * Date: 16/4/13 下午4:03
 * 说明：
 */
public class Action {
    @Getter
    @Setter
    private long actionId;
    @Getter
    @Setter
    private String table;
    @Getter
    @Setter
    private String field;
    @Getter
    @Setter
    private String targetId;
    @Getter
    @Setter
    private long number;
    @Getter
    @Setter
    private String timestamp;
    @Getter
    @Setter
    private long delay;
    @Getter
    @Setter
    private String destimate;

}
