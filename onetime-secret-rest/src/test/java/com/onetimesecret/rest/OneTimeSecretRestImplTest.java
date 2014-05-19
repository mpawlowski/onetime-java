package com.onetimesecret.rest;

import com.onetimesecret.spi.OneTimeSecret;
import com.onetimesecret.spi.ShareRequest;
import com.onetimesecret.spi.ShareResponse;
import org.testng.annotations.Test;

public class OneTimeSecretRestImplTest {

    @Test
    public void testShit() {
        OneTimeSecret ots = new OneTimeSecretRestImpl("marcin.lukasz.pawlowski@gmail.com", "379919a8f6196b4f90f5fa206290e6df304f5022");

        ShareRequest shareRequest = new ShareRequest.Builder().withSecret("test secret").build();

        System.out.println(ots.status().getStatus());

        ShareResponse response = ots.share(shareRequest);

        System.out.println(response);
    }
}
