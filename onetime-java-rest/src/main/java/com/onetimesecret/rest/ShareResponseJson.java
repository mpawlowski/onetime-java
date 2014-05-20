package com.onetimesecret.rest;

import com.onetimesecret.spi.ShareResponse;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class ShareResponseJson implements ShareResponse {

    @JsonProperty("custid")
    private String custId;
    @JsonProperty("metadata_key")
    private String metadataKey;
    @JsonProperty("secret_key")
    private String secretKey;
    @JsonProperty("metadata_ttl")
    private String metadataTtl;
    @JsonProperty("secret_ttl")
    private String secretTtl;
    @JsonProperty("ttl")
    private String ttl;
    @JsonProperty("state")
    private String state;
    @JsonProperty("created")
    private String dateCreated;
    @JsonProperty("updated")
    private String dateUpdated;
    @JsonProperty("passphrase_required")
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

    public String getMetadataTtl() {
        return metadataTtl;
    }

    public void setMetadataTtl(String metadataTtl) {
        this.metadataTtl = metadataTtl;
    }

    public String getSecretTtl() {
        return secretTtl;
    }

    public void setSecretTtl(String secretTtl) {
        this.secretTtl = secretTtl;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
