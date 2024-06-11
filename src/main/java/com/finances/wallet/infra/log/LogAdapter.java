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
                .withMessage("Application started successfully")
                .build();
        logger(log);
    }

    public void infoShutDown(
            String message,
            String correlationId
    ) {
        Log log = new Log.Builder()
                .withCorrelationId(correlationId)
                .withStatus(LogStatus.INFO_SHUTDOWN.getValue())
                .withMessage(message)
                .build();
        logger(log);
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
                .withMessage(message)
                .build();
        logger(log);
    }

    private void logger(Log logging) {
        logger.info(logging.getMessage(), StructuredArguments.keyValue(HEADER, logging));
        System.out.println(logging.toString());
    }
}
