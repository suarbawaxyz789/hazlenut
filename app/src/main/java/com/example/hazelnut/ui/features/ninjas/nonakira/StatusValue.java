package com.example.hazelnut.ui.features.ninjas.nonakira;

public enum StatusValue {
    VAN_FROM_NINJAVAN("VAN_FROM_NINJAVAN"),
    TRUCK("TRUCK"),
    SUCCESS("SUCCESS"),
    PENDING("PENDING"),
    FAIL("FAIL"),
    REJECT("REJECT"),
    SCAN("SCAN"),
    PARTIAL("PARTIAL"),
    CANCEL("CANCEL"),
    SYNCING("SYNCING"),
    ERROR("ERROR"),
    PICKUP_FAIL("Pickup fail");

    private String value;

    private StatusValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
