package com.onetimesecret.spi;

/**
 * @author mpawlowski
 * @since 1.0
 */
public interface ShareResponse {

    /**
     * @return this is you :]
     * @since 1.0
     */
    public String getCustId();

    /**
     * @return the unique key for the metadata. <b>DO NOT</b> share this.
     * @since 1.0
     */
    public String getMetadataKey();

    /**
     * @return the unique key for the secret you create. This is key that you can share.
     * @since 1.0
     */
    public String getSecretKey();

    /**
     * @return the time-to-live (in seconds) that was specified (i.e. not the time remaining).
     * @since 1.0
     */
    public String getTTL();

    /**
     * @return time the secret was created in unix time (UTC).
     * @since 1.0
     */
    public String getDateCreated();

    /**
     * @return time the secret was created in unix time (UTC).
     * @since 1.0
     */
    public String getDateUpdated();

    /**
     * @return if a passphrase was provided when the secret was created, this will be true. Otherwise false, obviously.
     * @since 1.0
     */
    public boolean isPassphraseRequired();

}
