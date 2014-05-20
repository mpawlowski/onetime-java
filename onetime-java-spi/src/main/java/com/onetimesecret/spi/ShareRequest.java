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
    private String secret;

    /**
     * @return a string that the recipient must know to view the secret. This value is also used to encrypt the secret
     * and is bcrypted before being stored so we only have this value in transit.
     * @since 1.0
     */
    private String passphrase;

    /**
     * @return the maximum amount of time, in seconds, that the secret should survive (i.e. time-to-live). Once this
     * time expires, the secret will be deleted and not recoverable.
     * @since 1.0
     */
    private String ttl;

    /**
     * @return an email address. We will send a friendly email containing the secret link (NOT the secret itself).
     * @since 1.0
     */
    private String recipient;

    private ShareRequest() {
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

    public static class Builder {

        private ShareRequest request;

        public Builder() {
            request = new ShareRequest();
        }

        public Builder withSecret(final String secret) {
            request.secret = secret;
            return this;
        }

        public Builder withPassphrase(final String passphrase) {
            request.passphrase = passphrase;
            return this;
        }

        public Builder withTTL(final String ttl) {
            request.ttl = ttl;
            return this;
        }

        public Builder withRecipient(final String recipient) {
            request.recipient = recipient;
            return this;
        }

        public ShareRequest build() {
            return request;
        }

    }
}
