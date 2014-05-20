package com.onetimesecret.spi;

/**
 * @author mpawlowski
 * @since 1.0
 */
public interface OneTimeSecret {

    /**
     * Current status of the system.
     *
     * @since 1.0
     */
    public Status status();

    /**
     * Stores a secret value.
     *
     * @since 1.0
     */
    public ShareResponse share(final ShareRequest shareRequest);

    /**
     * Generate a short, unique secret. This is useful for temporary passwords, one-time pads, salts, etc.
     *
     * @since 1.0
     */
    public GenerateResponse generate(final GenerateRequest generateRequest);

    /**
     * Retrieve a generated secret.
     *
     * @since 1.0
     */
    public RetrieveResponse retrieve(final RetrieveRequest retrieveRequest);

    /**
     * Every secret also has associated metadata. The metadata is intended to be used by the creator of the secret
     * (i.e. not the recipient) and should generally be kept private. You can safely use the metadata key to retrieve
     * basic information about the secret itself (e.g. if or when it was viewed) since the metadata key is different
     * from the secret key.
     *
     * @since 1.0
     */
    public MetadataResponse metadata(final MetadataRequest metadataRequest);
}
