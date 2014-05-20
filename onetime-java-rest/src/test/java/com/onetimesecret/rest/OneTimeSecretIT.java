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

        String username = System.getProperty("onetime-java.username");
        String apiKey = System.getProperty("onetime-java.apikey");

        if (StringUtils.isBlank(username)) {
            throw new IllegalStateException("username must be configured as the system property 'onetime-java.username'");
        }

        if (StringUtils.isBlank(apiKey)) {
            throw new IllegalStateException("apiKey username must be configured as the system property  'onetime-java.apikey'");
        }

        ots = new OneTimeSecretRestImpl(username, apiKey);
    }

    @Test
    public void TestGenerateRetrieve() {

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
    public void TestShareRetrieve() {

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
}
