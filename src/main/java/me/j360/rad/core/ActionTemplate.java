package me.j360.rad.core;

import lombok.Getter;
import lombok.Setter;
import me.j360.rad.action.ActionCenter;
import me.j360.rad.action.ActionCenterDelegate;
import me.j360.rad.model.Action;

/**
 * Package: me.j360.rad.core
 * User: min_xu
 * Date: 16/4/13 下午4:08
 * 说明：
 */
public class ActionTemplate{

    @Getter
    @Setter
    private ActionCenterDelegate actionDelegate;

    public void call(Action action){
        //调用delegate
        actionDelegate.call(action);
    }

}
