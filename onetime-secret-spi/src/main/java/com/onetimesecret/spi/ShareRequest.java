package com.onetimesecret.spi;

/**
 * @author mpawlowski
 * @since 1.0
 */
public class ShareRequest {

    /**
     * @return the secret value which is encrypted before being stored. There is a maximum length based on your plan
     * that is enforced (1k-10k).
     * @since 1.0
     */
    private final String secret;

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
     * @return an email address. We will send a friendly email containing the secret link (NOT the secret itself).
     * @since 1.0
     */
    private final String recipient;

    public ShareRequest(String secret, String passphrase, String ttl, String recipient) {
        this.secret = secret;
        this.passphrase = passphrase;
        this.ttl = ttl;
        this.recipient = recipient;
    }

    public String getSecret() {
        return secret;
    }

    public String getPassphrase() {
        return passphrase;
    }

    public String getTTL() {
        return ttl;
    }

    public String getRecipient() {
        return recipient;
    }

}
