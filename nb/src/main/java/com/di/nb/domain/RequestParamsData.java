package com.di.nb.domain;

public class RequestParamsData {
    private String device_id;

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    @Override
    public String toString() {
        return this.getDevice_id();
    }
}
