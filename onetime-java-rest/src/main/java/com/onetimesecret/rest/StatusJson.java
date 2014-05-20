package com.onetimesecret.rest;

import com.onetimesecret.spi.Status;

class StatusJson implements Status {

    private String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
