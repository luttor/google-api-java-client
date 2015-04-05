If you are developing for Android and the Google API you want to use is included in the [Google Play Services library](https://developer.android.com/google/play-services/index.html), use that library for the best performance and experience. If the Google API you want to use with Android is not part of the Google Play Services library, you can use the Google APIs Client Library for Java, which supports Android 1.5 (or higher), and which is described here.

Contents:


# Getting Started #

Begin by reading the [Android development instructions](http://code.google.com/p/google-http-java-client/wiki/Android) in the Google HTTP Client Library for Java documentation.

# Authentication #

As described in the [Android development instructions](http://code.google.com/p/google-http-java-client/wiki/Android), the best practice on Android (since the 2.1 SDK) is to use the [AccountManager](http://developer.android.com/reference/android/accounts/AccountManager.html) class (@Beta) for centralized identity management and credential token storage.

**OAuth 2.0**<br /> For information about the OAuth 2.0 flow, see the [OAuth 2.0 instructions for Android](OAuth2#Android.md).

**ClientLogin**<br /> ClientLogin is a [deprecated](https://developers.google.com/accounts/docs/AuthForInstalledApps?csw=1) authentication protocol used by older Google APIs. For new applications, we encourage you to use the more secure [OAuth 2.0](OAuth2.md) protocol. Support for ClientLogin in the Google APIs Client Library for Java will be removed.

Older Google APIs that support ClientLogin are well supported on Android. To get an auth token, call `AccountManager.getAuthToken()` with the appropriate `authTokenType` for the Google API you are using, for example `cl` for the Google Calendar Data API.

# Partial Response and Update #

Google APIs support a partial-response protocol that allows you to specify which fields are returned to you in the HTTP response.  This can significantly reduce the size of the response, thereby reducing network usage, parsing response time, and memory usage.  It works with both JSON and XML.

The following snippet of code drawn from the [Google+ Sample](http://code.google.com/p/google-api-java-client/source/browse/plus-cmdline-sample/src/main/java/com/google/api/services/samples/plus/cmdline/PlusSample.java?repo=samples) demonstrates how to use the partial-response protocol:

```
Plus.Activities.List listActivities = plus.activities().list("me", "public");
listActivities.setMaxResults(5L);
// Pro tip: Use partial responses to improve response time considerably
listActivities.setFields("nextPageToken,items(id,URL,object/content)");
ActivityFeed feed = listActivities.execute();
```

# Samples #

A good example that uses the generated service-specific library is [tasks-android-sample](http://samples.google-api-java-client.googlecode.com/hg/tasks-android-sample/instructions.html).  Another example can be found in [calendar-android-sample](http://samples.google-api-java-client.googlecode.com/hg/calendar-android-sample/instructions.html?r=default), which mixes ClientLogin with the service-specific library.

# Best-Practices Video (2011) #
In the following hour-long video from Google I/O 2011, Yaniv Inbar describes best practices for accessing Google APIs on Android.

<a href='http://www.youtube.com/watch?feature=player_embedded&v=9fBcrzA-hWY' target='_blank'><img src='http://img.youtube.com/vi/9fBcrzA-hWY/0.jpg' width='425' height=344 /></a>