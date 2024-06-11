package com.finances.wallet.infra.listener;

import com.finances.wallet.infra.log.LogAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ShutDownDownEventListener implements ApplicationListener<ContextClosedEvent> {

    @Autowired
    private LogAdapter logAdapter;
    private static final long GRACEFUL_PERIOD = 30 * 1000;
    private static final String TRACE = "com.finances.wallet.infra.listener";

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        String correlationId = UUID.randomUUID().toString();
        logAdapter.infoShutDown(
            "application shutdown process has started",
                correlationId
        );

       applySleep(correlationId);

        logAdapter.infoShutDown(
                "graceful shutdown process completed successfully",
                correlationId
        );
    }

    private void applySleep(String correlationId) {
        try {
            Thread.sleep(GRACEFUL_PERIOD);
        } catch (InterruptedException e) {
            logAdapter.error(
                    System.out.format("error applying graceful 30s sleep before kill app. Reason: %s", e.getMessage()).toString(),
                    correlationId,
                    TRACE
            );
        }
    }
}
