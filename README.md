onetime-java
============

Java implementation of the https://github.com/onetimesecret/onetimesecret REST api.

###Usage

    OneTimeSecret ots = new OneTimeSecretRestImpl("OneTime Secret username", "OneTime Secret Api Key");
    
    GenerateResponse generateResponse = ots.generate(
                    new GenerateRequest.Builder()
                            .withPassphrase("supersecret")
                            .build());
                    
    RetrieveResponse retrieveResponse = ots.retrieve(
                    new RetrieveRequest.Builder()
                            .withSecretKey(shareResponse.getSecretKey())
                            .withPassphrase("supersecret)
                            .build());
                            
    assertEquals(generateResponse.getValue(), retrieveResponse.getValue());
