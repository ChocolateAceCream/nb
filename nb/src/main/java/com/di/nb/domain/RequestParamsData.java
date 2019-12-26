package com.di.nb.domain;

public class RequestParamsData {
    private String deviceId;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return this.getDeviceId();
    }
}
