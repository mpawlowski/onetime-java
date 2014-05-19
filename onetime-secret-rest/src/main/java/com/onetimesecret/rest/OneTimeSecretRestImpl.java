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

    private static final String URL = "https://onetimesecret.com/api";

    private Feature authFeature;

    public OneTimeSecretRestImpl(final String username, final String apiToken) {
        if (StringUtils.isBlank(username)) {
            throw new IllegalStateException("One Time Secret username must be set");
        }
        if (StringUtils.isBlank(apiToken)) {
            throw new IllegalStateException("One Time Secret api token must be set");
        }
        authFeature = HttpAuthenticationFeature.basic(username, apiToken);
    }

    private WebTarget webTarget() {
        return ClientBuilder.newClient()
                .register(authFeature)
                .register(new JacksonFeature())
                .target(URL);
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
        return null;
    }

    @Override
    public RetrieveResponse retrieve(RetrieveRequest retrieveRequest) {
        return null;
    }

    @Override
    public MetadataResponse metadata(MetadataRequest metadataRequest) {
        return null;
    }

}
