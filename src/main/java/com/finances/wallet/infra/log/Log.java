package com.finances.wallet.infra.log;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Data
public class Log {
    private static final String APPLICATION_NAME = "WALLET";
    private String correlationId;
    private String serviceName;
    private String status;
    private String trace;
    private LocalDateTime ts;
    private String message;

    private Log() {
        this.serviceName = APPLICATION_NAME;
    }

    @Override
    public String toString() {
        return "{" +
                "correlationId:'" + correlationId + '\'' +
                ", serviceName:'" + serviceName + '\'' +
                ", status:'" + status + '\'' +
                ", trace:'" + trace + '\'' +
                ", ts:" + ts +
                ", message:'" + message + '\'' +
                '}';
    }


    public static final class Builder {
        private Log log;

        public Builder() {
            this.log = new Log();
            withTs();
        }

        public Builder withCorrelationId(String correlationId) {
            this.log.correlationId = correlationId;
            return this;
        }

        public Builder withStatus(String status) {
            this.log.status = status;
            return this;
        }

        public Builder withTrace(String trace) {
            this.log.trace = trace;
            return this;
        }

        public Builder withMessage(String message) {
            this.log.message = message;
            return this;
        }

        private void withTs() {
            this.log.ts =  new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().withNano(0);
        }

        public Log build() {
            return this.log;
        }
    }
}
