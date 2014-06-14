#onetime-java [![Build Status](https://drone.io/github.com/mpawlowski/onetime-java/status.png)](https://drone.io/github.com/mpawlowski/onetime-java/latest)

Java implementation of the https://github.com/onetimesecret/onetimesecret REST api.

###Usage Example

Add a maven dependency to the onetime-java-rest artifact.

    <dependency>
        <groupId>com.onetimesecret</groupId>
        <artifactId>onetime-java-rest</artifactId>
        <version>1.0</version>
    </dependency>

Then use it to generate and retrieve secrets to your liking.

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
                            .withSecretKey(generateResponse.getSecretKey())
                            .withPassphrase("supersecret")
                            .build());
                            
    assertEquals(generateResponse.getValue(), retrieveResponse.getValue());
