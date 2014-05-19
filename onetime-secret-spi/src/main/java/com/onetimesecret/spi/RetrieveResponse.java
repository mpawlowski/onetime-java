package com.onetimesecret.spi;

/**
 * @author mpawlowski
 * @since 1.0
 */
public interface RetrieveResponse {

    /**
     * @return the unique key for the secret you create. This is key that you can share.
     * @since 1.0
     */
    public String getSecretKey();

    /**
     * @return the actual secret. It should go without saying, but this will only be available one time.
     * @since 1.0
     */
    public String getValue();
}
