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
    private String passphrase;

    /**
     * @return the maximum amount of time, in seconds, that the secret should survive (i.e. time-to-live). Once this
     * time expires, the secret will be deleted and not recoverable.
     * @since 1.0
     */
    private String ttl;

    /**
     * @return The remaining time (in seconds) that the metadata has left to live.
     * @since 1.0
     */
    private String metadataTTL;

    /**
     * @return The remaining time (in seconds) that the secret has left to live.
     * @since 1.0
     */
    private String secretTTL;

    /**
     * @return an email address. We will send a friendly email containing the secret link (NOT the secret itself).
     * @since 1.0
     */
    private String[] recipient;

    private GenerateRequest() {
    }

    public String getPassphrase() {
        return passphrase;
    }

    public String getTtl() {
        return ttl;
    }

    public String getMetadataTtl() {
        return metadataTTL;
    }

    public String getSecretTtl() {
        return secretTTL;
    }

    public String[] getRecipient() {
        return recipient;
    }

    public static class Builder {

        private GenerateRequest generateRequest;

        public Builder() {
            generateRequest = new GenerateRequest();
        }

        public Builder withPassphrase(final String passphrase) {
            generateRequest.passphrase = passphrase;
            return this;
        }

        public Builder withTtl(final String ttl) {
            generateRequest.ttl = ttl;
            return this;
        }

        public Builder withMetadataTtl(final String metadataTtl) {
            generateRequest.metadataTTL = metadataTtl;
            return this;
        }

        public Builder withSecretTtl(final String secretTtl) {
            generateRequest.passphrase = secretTtl;
            return this;
        }

        public Builder withRecipient(final String... recipient) {
            generateRequest.recipient = recipient;
            return this;
        }

        public GenerateRequest build() {
            return generateRequest;
        }

    }
}
