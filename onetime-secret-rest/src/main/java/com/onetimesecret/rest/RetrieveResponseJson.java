package com.onetimesecret.rest;

import com.onetimesecret.spi.RetrieveResponse;
import org.codehaus.jackson.annotate.JsonProperty;

class RetrieveResponseJson implements RetrieveResponse{

    @JsonProperty("secret_key")
    private String secretKey;
    @JsonProperty("value")
    private String value;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
