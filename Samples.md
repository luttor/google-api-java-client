# Available Samples #

To view all the samples that are available for the Google APIs Client Library for Java, browse through the [samples in the project site](http://code.google.com/p/google-api-java-client/source/browse?repo=samples). Each sample has an instructions.html file that explains how to set up and use the sample. (To more easily view the instructions in a browser, visit http://samples.google-api-java-client.googlecode.com/hg/.)

We welcome contributions for samples for other APIs, as described in our guide to [becoming a contributor](BecomingAContributor.md).

If you would like to request a sample for other APIs that are not listed here, please post your requests on the API specific sites such as developers.google.com or [StackOverflow](http://stackoverflow.com/)


# Google+ Sample #

A complete Google+ example is given in the [plus-cmdline-sample](http://samples.google-api-java-client.googlecode.com/hg/plus-cmdline-sample/instructions.html) sample.

The following code snippet shows a short example of how to use the client library with the [Google+ API](https://developers.google.com/+/api/).

```
...

String APPLICATION_NAME = "PlusSample";
java.io.File DATA_STORE_DIR =
      new java.io.File(System.getProperty("user.home"), ".store/plus_sample");
FileDataStoreFactory dataStoreFactory;

// Set up the HTTP transport and JSON factory
HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

// Load client secrets
GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory,
    new InputStreamReader(PlusSample.class.getResourceAsStream("/client_secrets.json")));

// Set up authorization code flow
GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
    httpTransport, jsonFactory, clientSecrets,
    Collections.singleton(PlusScopes.PLUS_ME)).setDataStoreFactory(dataStoreFactory)
    .build();

// Authorize
Credential credential =
    new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");

// Set up the main Google+ class
Plus plus = new Plus.Builder(httpTransport, jsonFactory, credential)
    .setApplicationName(APPLICATION_NAME)
    .build();

// Make a request to access your profile and display it to console
Person profile = plus.people().get("me").execute();
System.out.println("ID: " + profile.getId());
System.out.println("Name: " + profile.getDisplayName());
System.out.println("Image URL: " + profile.getImage().getUrl());
System.out.println("Profile URL: " + profile.getUrl());
```