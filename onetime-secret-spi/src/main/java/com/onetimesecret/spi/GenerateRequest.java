package com.onetimesecret.spi;

/**
 * @author mpawlowski
 * @since 1.0
 */
public class GenerateRequest {

    /**
     * @return a string that the recipient must know to view the secret. This value is also used to encrypt the secret
     * and is bcrypted before being stored so we only have this value in transit.
     * @since 1.0
     */
    private final String passphrase;

    /**
     * @return the maximum amount of time, in seconds, that the secret should survive (i.e. time-to-live). Once this
     * time expires, the secret will be deleted and not recoverable.
     * @since 1.0
     */
    private final String ttl;

    /**
     * @return The remaining time (in seconds) that the metadata has left to live.
     * @since 1.0
     */
    private final String metadataTTL;

    /**
     * @return The remaining time (in seconds) that the secret has left to live.
     * @since 1.0
     */
    private final String secretTTL;

    /**
     * @return an email address. We will send a friendly email containing the secret link (NOT the secret itself).
     * @since 1.0
     */
    private final String recipient;

    public GenerateRequest(String passphrase, String ttl, String metadataTTL, String secretTTL, String recipient) {
        this.passphrase = passphrase;
        this.ttl = ttl;
        this.metadataTTL = metadataTTL;
        this.secretTTL = secretTTL;
        this.recipient = recipient;
    }

    public String getPassphrase() {
        return passphrase;
    }

    public String getTtl() {
        return ttl;
    }

    public String getMetadataTTL() {
        return metadataTTL;
    }

    public String getSecretTTL() {
        return secretTTL;
    }

    public String getRecipient() {
        return recipient;
    }
}
