# Setting Timeouts #

In the following example, which uses the [Google Analytics API](https://developers.google.com/api-client-library/java/apis/analytics/v3), the `setConnectTimeout` and `setReadTimeout` methods are used to set the connect and read timeouts to three minutes (in milliseconds) for all requests:

```
private HttpRequestInitializer setHttpTimeout(final HttpRequestInitializer requestInitializer) {
  return new HttpRequestInitializer() {
    @Override
    public void initialize(HttpRequest httpRequest) throws IOException {
      requestInitializer.initialize(httpRequest);
      httpRequest.setConnectTimeout(3 * 60000);  // 3 minutes connect timeout
      httpRequest.setReadTimeout(3 * 60000);  // 3 minutes read timeout
    }
  };

GoogleCredential credential = ....

final Analytics analytics = Analytics.builder(new NetHttpTransport(), jsonFactory, setHttpTimeout(credential)).build();
```

# Handling HTTP Error Responses from Google APIs #

A [GoogleJsonResponseException](http://javadoc.google-api-java-client.googlecode.com/hg/1.18.0-rc/com/google/api/client/googleapis/json/GoogleJsonResponseException.html) is thrown from the generated libraries when an error status code is detected in an HTTP response to a Google API that uses the JSON format.
The errors use the format specified in [Error responses](http://code.google.com/apis/urlshortener/v1/getting_started.html#errors).

The following example shows a way to handle these exceptions:

```
Plus.Activities.List listActivities = plus.activities().list("me", "public");
try {
  ActivityFeed feed = listActivities.execute();
  ...
} catch (GoogleJsonResponseException e) {
  System.err.println(e.getDetails());
}
```