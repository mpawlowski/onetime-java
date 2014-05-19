package com.onetimesecret.rest;

import com.onetimesecret.spi.ShareResponse;

class ShareResponseJson implements ShareResponse {

    private String custId;
    private String metadataKey;
    private String secretKey;
    private String ttl;
    private String dateCreated;
    private String dateUpdated;
    private boolean isPassphraseRequired;



    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getMetadataKey() {
        return metadataKey;
    }

    public void setMetadataKey(String metadataKey) {
        this.metadataKey = metadataKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public boolean isPassphraseRequired() {
        return isPassphraseRequired;
    }

    public void setPassphraseRequired(boolean isPassphraseRequired) {
        this.isPassphraseRequired = isPassphraseRequired;
    }
}
