package me.j360.rad.spring;

import lombok.Getter;
import lombok.Setter;
import me.j360.rad.action.ActionCenter;
import me.j360.rad.action.ActionCenterFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Package: me.j360.rad.spring
 * User: min_xu
 * Date: 16/4/13 下午7:18
 * 说明：
 */
public class ActionCenterFactoryBean implements FactoryBean<ActionCenter>,
        InitializingBean, DisposableBean {

    @Getter
    @Setter
    private ActionCenter actionCenter;

    public void destroy() throws Exception {

    }

    public ActionCenter getObject() throws Exception {
        return actionCenter;
    }

    public Class<?> getObjectType() {
        return actionCenter.getClass();
    }

    public boolean isSingleton() {
        return false;
    }

    public void afterPropertiesSet() throws Exception {

    }
}
