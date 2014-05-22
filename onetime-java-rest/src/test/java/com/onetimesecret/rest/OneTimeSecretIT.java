package com.onetimesecret.rest;

import com.onetimesecret.spi.*;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = "integration")
public class OneTimeSecretIT {

    private OneTimeSecret ots;

    @BeforeClass
    public void setUp() {

        String url = "https://onetimesecret.com/api";
        String username = System.getProperty("onetime-java.username");
        String apiKey = System.getProperty("onetime-java.apikey");

        if (StringUtils.isBlank(username)) {
            throw new IllegalStateException("username must be configured as the system property 'onetime-java.username'");
        }

        if (StringUtils.isBlank(apiKey)) {
            throw new IllegalStateException("apiKey username must be configured as the system property 'onetime-java.apikey'");
        }

        ots = new OneTimeSecretRestImpl(url, username, apiKey);
    }

    @Test
    public void testGenerateRetrieve() {

        GenerateRequest generateRequest = new GenerateRequest.Builder()
                .withPassphrase("test-passphrase")
                .build();

        GenerateResponse generateResponse = ots.generate(generateRequest);
        RetrieveResponse retrieveResponse = ots.retrieve(
                new RetrieveRequest.Builder()
                        .withSecretKey(generateResponse.getSecretKey())
                        .withPassphrase(generateRequest.getPassphrase())
                        .build()
        );

        Assert.assertEquals(generateResponse.getValue(), retrieveResponse.getValue());
    }

    @Test
    public void testShareRetrieve() {

        ShareRequest shareRequest = new ShareRequest.Builder()
                .withSecret("mooooo I'm a moooose")
                .withPassphrase("test-passhprase")
                .build();

        ShareResponse shareResponse = ots.share(shareRequest);
        RetrieveResponse retrieveResponse = ots.retrieve(
                new RetrieveRequest.Builder()
                        .withSecretKey(shareResponse.getSecretKey())
                        .withPassphrase(shareRequest.getPassphrase())
                        .build()
        );

        Assert.assertEquals(shareRequest.getSecret(), retrieveResponse.getValue());
    }

    @Test
    public void testGenerateMetadata() {

        GenerateResponse generateResponse = ots.generate(new GenerateRequest.Builder()
                .withPassphrase("ooga booga")
                .withMetadataTtl("111")
                .withSecretTtl("222")
                .withTtl("333")
                .build());

        MetadataResponse metadataResponse = ots.metadata(new MetadataRequest.Builder()
                .withMetadataKey(generateResponse.getMetadataKey())
                .build());

        Assert.assertEquals(metadataResponse.getCustId(), generateResponse.getCustId());
        Assert.assertEquals(metadataResponse.getDateCreated(), generateResponse.getDateCreated());
        Assert.assertEquals(metadataResponse.getMetadataKey(), generateResponse.getMetadataKey());
        Assert.assertEquals(metadataResponse.getSecretKey(), generateResponse.getSecretKey());
        Assert.assertEquals(metadataResponse.getTtl(), generateResponse.getTtl());

    }
}
