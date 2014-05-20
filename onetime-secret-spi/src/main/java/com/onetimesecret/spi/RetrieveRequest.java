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
    private String secretKey;

    /**
     * @return (if required): the passphrase is required only if the secret was create with one.
     */
    private String passphrase;

    public RetrieveRequest() {
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getPassphrase() {
        return passphrase;
    }

    public static class Builder {

        private RetrieveRequest retrieveRequest;

        public Builder() {
            retrieveRequest = new RetrieveRequest();
        }

        public Builder withSecretKey(final String secretKey) {
            retrieveRequest.secretKey = secretKey;
            return this;
        }

        public Builder withPassphrase(final String passphrase) {
            retrieveRequest.passphrase = passphrase;
            return this;
        }

        public RetrieveRequest build() {
            return retrieveRequest;
        }
    }
}
