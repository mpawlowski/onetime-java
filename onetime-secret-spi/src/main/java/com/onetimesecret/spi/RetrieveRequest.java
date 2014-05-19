package com.onetimesecret.spi;

/**
 * @author mpawlowski
 * @since 1.0
 */
public class RetrieveRequest {

    /**
     * @return the unique key for this secret.
     * @since 1.0
     */
    private final String secretKey;

    /**
     * @return (if required): the passphrase is required only if the secret was create with one.
     */
    private final String passphrase;

    public RetrieveRequest(String secretKey, String passphrase) {
        this.secretKey = secretKey;
        this.passphrase = passphrase;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getPassphrase() {
        return passphrase;
    }
}
