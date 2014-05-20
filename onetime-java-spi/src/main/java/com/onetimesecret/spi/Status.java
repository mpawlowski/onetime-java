package com.onetimesecret.spi;

/**
 * @author mpawlowski
 * @since 1.0
 */
public interface Status {

    /**
     * @return 'nominal' if things are running smoothly, 'offline' if not.
     */
    public String getStatus();
}
