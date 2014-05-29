#onetime-java [![Build Status](https://drone.io/github.com/mpawlowski/onetime-java/status.png)](https://drone.io/github.com/mpawlowski/onetime-java/latest)

Java implementation of the https://github.com/onetimesecret/onetimesecret REST api.

###Usage Example

    OneTimeSecret ots = new OneTimeSecretRestImpl(
        "https://path/to/ots/instance",
        "ots-username",
        "ots-apikey");
    
    GenerateResponse generateResponse = ots.generate(
                    new GenerateRequest.Builder()
                            .withPassphrase("supersecret")
                            .build());
                    
    RetrieveResponse retrieveResponse = ots.retrieve(
                    new RetrieveRequest.Builder()
                            .withSecretKey(shareResponse.getSecretKey())
                            .withPassphrase("supersecret")
                            .build());
                            
    assertEquals(generateResponse.getValue(), retrieveResponse.getValue());
