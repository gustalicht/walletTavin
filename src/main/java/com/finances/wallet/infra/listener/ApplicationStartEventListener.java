package com.finances.wallet.infra.listener;

import com.finances.wallet.infra.log.LogAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartEventListener implements ApplicationListener<ContextStartedEvent> {

    @Autowired
    private LogAdapter logAdapter;

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        logAdapter.infoStart();
    }
}
