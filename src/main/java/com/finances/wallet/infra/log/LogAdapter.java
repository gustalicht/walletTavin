package com.finances.wallet.infra.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.logstash.logback.argument.StructuredArguments;
import org.springframework.stereotype.Component;

@Component
public class LogAdapter {

    private static final String HEADER = "header";

    private static Logger logger;

    public LogAdapter() {
        logger = LoggerFactory.getLogger(LogAdapter.class);
    }

    public void infoStart() {
        Log log = new Log.Builder()
                .withStatus(LogStatus.INFO_START.getValue())
                .build();
        logger("Application started successfully", log);
    }

    public void infoShutDown(
            String message,
            String correlationId
    ) {
        Log log = new Log.Builder()
                .withCorrelationId(correlationId)
                .withStatus(LogStatus.INFO_SHUTDOWN.getValue())
                .build();
        logger(message, log);
    }

    public void error(
            String message,
            String correlationId,
            String trace
    ) {
        Log log = new Log.Builder()
                .withCorrelationId(correlationId)
                .withStatus(LogStatus.ERROR.getValue())
                .withTrace(trace)
                .build();
        logger(message, log);
    }

    private void logger(String message, Log logging) {
        logger.info(message, StructuredArguments.keyValue(HEADER, logging));
    }
}
