package me.j360.rad.redis;

import me.j360.rad.action.ActionCenter;
import me.j360.rad.model.Action;
import me.j360.rad.model.ActionTarget;

import java.util.List;

/**
 * Package: me.j360.rad.redis
 * User: min_xu
 * Date: 16/4/13 下午4:25
 * 说明：
 */
public class RedisActionCenter implements ActionCenter {


    public void writeToCache(ActionTarget actionTarget) {

    }

    @Override
    public void writeToDatabase(Action action) {
        //将单条数据写到数据库

    }

    @Override
    public void writeToDatabase(List<Action> actions) {
        //批量将数据写到数据库

    }

    @Override
    public ActionTarget getActionTarget(long targetId) {

        return new ActionTarget();
    }


    private boolean checkDelay(){
        return true;
    }

    private void asyncCall(){

    }

}
