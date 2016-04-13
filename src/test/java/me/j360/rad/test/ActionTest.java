package me.j360.rad.test;

import lombok.extern.slf4j.Slf4j;
import me.j360.rad.core.ActionTemplate;
import me.j360.rad.model.Action;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Package: me.j360.rad.test
 * User: min_xu
 * Date: 16/4/13 下午7:29
 * 说明：
 */
@Slf4j
@ActiveProfiles("dev")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback=false)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class ActionTest {

    @Autowired
    private ActionTemplate actionTemplate;

    @Test
    public void call(){
        Action action = new Action();
        actionTemplate.call(action);
    }
}
