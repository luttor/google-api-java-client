Each HTTP connection that your client makes results in overhead. To reduce  overhead, you can batch multiple API calls together into a single HTTP request.

The main classes of interest are [BatchRequest](http://javadoc.google-api-java-client.googlecode.com/hg/1.18.0-rc/com/google/api/client/googleapis/batch/BatchRequest.html) and [JsonBatchCallback](http://javadoc.google-api-java-client.googlecode.com/hg/1.18.0-rc/com/google/api/client/googleapis/batch/json/JsonBatchCallback.html). The following example shows how to use these classes with service-specific generated libraries:

```
JsonBatchCallback<Calendar> callback = new JsonBatchCallback<Calendar>() {
  
  public void onSuccess(Calendar calendar, HttpHeaders responseHeaders) {
    printCalendar(calendar);
    addedCalendarsUsingBatch.add(calendar);
  }

  public void onFailure(GoogleJsonError e, HttpHeaders responseHeaders) {
    System.out.println("Error Message: " + e.getMessage());
  }
};

...

Calendar client = Calendar.builder(transport, jsonFactory, credential)
  .setApplicationName("BatchExample/1.0").build();
BatchRequest batch = client.batch();

Calendar entry1 = new Calendar().setSummary("Calendar for Testing 1"); 
client.calendars().insert(entry1).queue(batch, callback);

Calendar entry2 = new Calendar().setSummary("Calendar for Testing 2"); 
client.calendars().insert(entry2).queue(batch, callback);

batch.execute();
```

A complete example of batch using the [Calendar API](https://developers.google.com/api-client-library/java/apis/calendar/v3) is available in the [calendar-cmdline-sample](http://samples.google-api-java-client.googlecode.com/hg/calendar-cmdline-sample/instructions.html).

You can also use the batch feature without service-specific generated libraries. To do this:
  1. Change the batch URL to your own URL.
  1. Call [BatchRequest.setBatchUrl](http://javadoc.google-api-java-client.googlecode.com/hg/1.18.0-rc/com/google/api/client/googleapis/batch/BatchRequest.html#setBatchUrl%28com.google.api.client.http.GenericUrl%29).
  1. Queue the HTTP requests by calling [BatchRequest.queue](http://javadoc.google-api-java-client.googlecode.com/hg/1.18.0-rc/com/google/api/client/googleapis/batch/BatchRequest.html#queue%28com.google.api.client.http.HttpRequest,%20java.lang.Class,%20java.lang.Class,%20com.google.api.client.googleapis.batch.BatchCallback%29).

The following example shows how to use batch in this generic way:

```
  BatchRequest batch = new BatchRequest(httpTransport, httpRequestInitializer);
  batch.setBatchUrl(new GenericUrl(/*your customized batch URL goes here*/));
  batch.queue(httpRequest1, dataClass, errorClass, callback);
  batch.queue(httpRequest1, dataClass, errorClass, callback);
  batch.execute();
```