package me.j360.rad.action;

import me.j360.rad.model.Action;
import me.j360.rad.model.ActionTarget;
import me.j360.rad.util.NamedThreadFactory;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Package: me.j360.rad.action
 * User: min_xu
 * Date: 16/4/13 下午4:12
 * 说明：
 */
public class ActionCenterDelegate implements ActionCenter{

    private ActionCenterFactory actionCenterFactory;

    private ActionCenter actionCenter;

    private ScheduledExecutorService executor;

    private ScheduledFuture scheduledFuture;

    private AtomicBoolean flushing = new AtomicBoolean(false);

    public ActionCenterDelegate(){
        this.actionCenter = actionCenterFactory.getActionCenter();
    }

    //入口
    public void call(Action action) {
        long targetId = 0;
        ActionTarget actionTarget = getActionTarget(targetId);
        //写入缓存新的数据
        writeToCache(actionTarget);

        boolean isWrite = false;

        if(actionTarget.getCount() == actionTarget.getNextCount()){
            //同步到数据库
            isWrite = true;
            writeToDatabase(action);
        }
        if(isWrite == false){
            if(new Date(actionTarget.getTimestamp()).after(new Date())){
                //同步到数据库
                isWrite = true;
                writeToDatabase(action);
            }
        }

        //补一个定时队列去判断是否有必要在下一个call之前检查
        schedulerCheck(action);
    }

    public void writeToCache(ActionTarget actionTarget) {
        actionCenter.writeToCache(actionTarget);
    }

    public void writeToDatabase(Action action) {
        actionCenter.writeToDatabase(action);
    }

    @Override
    public void writeToDatabase(List<Action> actions) {

    }

    @Override
    public ActionTarget getActionTarget(long targetId) {
        return actionCenter.getActionTarget(targetId);
    }

    private void schedulerCheck(final Action action){
        //
        executor = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("LazyAction"));
        scheduledFuture = executor.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    if (flushing.compareAndSet(false, true)) {
                        //
                        writeToDatabase(action);
                    }
                } catch (Throwable t) {

                }
            }
        }, 30, 30, TimeUnit.SECONDS);


    }

}
