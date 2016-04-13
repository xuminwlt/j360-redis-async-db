package me.j360.rad.action;

import me.j360.rad.model.Action;
import me.j360.rad.model.ActionTarget;

import java.util.List;

/**
 * Package: me.j360.rad.action
 * User: min_xu
 * Date: 16/4/13 下午4:10
 * 说明：
 */
public interface ActionCenter {

    public void writeToCache(ActionTarget actionTarget);
    public void writeToDatabase(Action action);

    public void writeToDatabase(List<Action> actions);

    public ActionTarget getActionTarget(long targetId);
}
