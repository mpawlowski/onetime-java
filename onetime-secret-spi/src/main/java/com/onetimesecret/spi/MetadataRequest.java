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
    private final String metadataKey;

    public MetadataRequest(final String metadataKey) {
        this.metadataKey = metadataKey;
    }

    public String getMetadataKey() {
        return metadataKey;
    }
}
