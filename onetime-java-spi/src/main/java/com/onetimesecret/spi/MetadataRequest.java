package com.onetimesecret.spi;

/**
 * @author mpawlowski
 * @since 1.0
 */
public class MetadataRequest {

    /**
     * @return the unique key for this metadata.
     * @since 1.0
     */
    private String metadataKey;

    private MetadataRequest() {
    }

    public String getMetadataKey() {
        return metadataKey;
    }

    public static class Builder {

        private MetadataRequest metadataRequest;

        public Builder() {
            metadataRequest = new MetadataRequest();
        }

        public Builder withMetadataKey(final String metadataKey) {
            metadataRequest.metadataKey = metadataKey;
            return this;
        }

        public MetadataRequest build() {
            return metadataRequest;
        }

    }
}
