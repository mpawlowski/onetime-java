package com.onetimesecret.rest;

import com.onetimesecret.spi.*;
import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Feature;

/**
 * @author mpawlowski
 * @since 1.0
 */
public class OneTimeSecretRestImpl implements OneTimeSecret {

    private String url;
    private Feature authFeature;

    public OneTimeSecretRestImpl(
            final String url,
            final String username,
            final String apiToken) {
        if (StringUtils.isBlank(url)) {
            throw new IllegalArgumentException("One Time Secret url must be set");
        }
        if (StringUtils.isBlank(username)) {
            throw new IllegalArgumentException("One Time Secret username must be set");
        }
        if (StringUtils.isBlank(apiToken)) {
            throw new IllegalArgumentException("One Time Secret api token must be set");
        }
        this.url = url;
        authFeature = HttpAuthenticationFeature.basic(username, apiToken);
    }

    private WebTarget webTarget() {
        return ClientBuilder.newClient()
                .register(authFeature)
                .register(new JacksonFeature())
                .target(url);
    }

    @Override
    public Status status() {
        return webTarget()
                .path("v1/status")
                .request()
                .get(StatusJson.class);
    }

    @Override
    public ShareResponse share(ShareRequest shareRequest) {
        return webTarget()
                .path("v1/share")
                .queryParam("secret", shareRequest.getSecret())
                .queryParam("passphrase", shareRequest.getPassphrase())
                .queryParam("ttl", shareRequest.getTTL())
                .queryParam("recipient", shareRequest.getRecipient())
                .request()
                .post(null, ShareResponseJson.class);
    }

    @Override
    public GenerateResponse generate(GenerateRequest generateRequest) {
        return webTarget()
                .path("v1/generate" )
                .queryParam("passphrase", generateRequest.getPassphrase())
                .queryParam("ttl", generateRequest.getTtl())
                .queryParam("metadata_ttl", generateRequest.getMetadataTtl())
                .queryParam("secret_ttl", generateRequest.getSecretTtl())
                .queryParam("recipient", generateRequest.getRecipient())
                .request()
                .post(null, GenerateResponseJson.class);
    }

    @Override
    public RetrieveResponse retrieve(RetrieveRequest retrieveRequest) {
        return webTarget()
                .path("v1/secret/" + retrieveRequest.getSecretKey())
                .queryParam("secret_key", retrieveRequest.getSecretKey())
                .queryParam("passphrase", retrieveRequest.getPassphrase())
                .request()
                .post(null, RetrieveResponseJson.class);
    }

    @Override
    public MetadataResponse metadata(MetadataRequest metadataRequest) {
        return webTarget()
                .path("v1/private/" + metadataRequest.getMetadataKey())
                .queryParam("metadata_key", metadataRequest.getMetadataKey())
                .request()
                .post(null, MetadataResponseJson.class);
    }

}
