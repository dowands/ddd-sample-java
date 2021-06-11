package com.example.dddsample.adapter.event.handle;

import com.example.dddsample.app.command.CustomerCmd;
import com.example.dddsample.app.query.CustomerQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created on 2021/6/9.
 *
 * @author Beiyuan Zhang
 */
@Component
public class MqHandler {

    @Autowired
    CustomerCmd customerCmd;

    public void onEvent(){
        customerCmd.doEvent();
    }
}
