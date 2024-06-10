package com.finances.wallet.infra.log;

public enum LogStatus {
    INFO_START("INFO_START"),
    INFO_SHUTDOWN ("INFO_SHUTDOWN"),
    WARNING ("WARNING"),
    ERROR ("ERROR");

    private String value;

    public String getValue() {
        return this.value;
    }

    private LogStatus(String value) {
        this.value = value;
    }
}
