| [Developer's Guide](DeveloperGuide.md) | [Libraries and Samples](https://developers.google.com/api-client-library/java/apis/) | [JavaDoc](http://javadoc.google-api-java-client.googlecode.com/hg/index.html) | [Get Help](Support.md) |
|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# Google APIs Client Library for Java  #

<font color='red'><b>This has moved to GitHub:</b></font> https://github.com/google/google-api-java-client

_Issues have been migrated to the [GitHub issue tracker](https://github.com/google/google-api-java-client/issues). If you own an open issue on this site, you can find a copy of it on GitHub. Please leave your comments over there._

  * [Overview](#Overview.md)
  * [Highlighted Features](#Highlighted_Features.md)
  * [Dependencies](#Dependencies.md)
  * [Important Warnings](#Important_Warnings.md)
    * [@Beta](#@Beta.md)
    * [Deprecations](#Deprecations.md)

# Overview #

The Google APIs Client Library for Java is a flexible, efficient, and powerful Java client library for accessing any HTTP-based API on the web, not just Google APIs.

The library has the following features:
  * A powerful [OAuth 2.0](http://code.google.com/p/google-api-java-client/wiki/OAuth2) library with a consistent interface.
  * Lightweight, efficient XML and JSON data models that support any data schema.
  * Support for [protocol buffers](https://code.google.com/p/protobuf/).
  * A set of [generated libraries for Google APIs](https://developers.google.com/api-client-library/java/apis/).

**Accessing Google APIs**

To use Google's Java client libraries to call any Google API, you need two libraries:

  * The core Google APIs Client Library for Java (google-api-java-client), which is the generic runtime library described here. This library provides functionality common to all APIs, for example HTTP transport, error handling, authentication, JSON parsing, media download/upload, and batching.
  * An auto-generated Java library for the API you are accessing, for example the [generated Java library for the BigQuery API](https://code.google.com/p/google-api-java-client/source/browse/bigquery-appengine-sample/?repo=samples#bigquery-appengine-sample%2Fsrc%2Fmain%2Fjava%2Fcom%2Fgoogle%2Fapi%2Fclient%2Fsample%2Fbigquery%2Fappengine%2Fdashboard%253Fstate%253Dclosed). These generated libraries include API-specific information such as the root URL, and classes that represent entities in the context of the API. These classes are useful for making conversions between JSON objects and Java objects.

To find the generated library for a Google API, visit [Google APIs Client Library for Java](https://developers.google.com/api-client-library/java/apis/). The API-specific Java packages include both the core google-api-java-client and the client-specific libraries.

If you are using the old GData library, you need to [migrate](http://code.google.com/p/gdata-java-client/wiki/MigratingToGoogleApiJavaClient).

**Developing for Android**

If you are developing for Android and the Google API you want to use is included in the [Google Play Services library](https://developer.android.com/google/play-services/index.html), you should use that library for the best performance and experience.

To access other Google APIs, you can use the Google APIs Client Library for Java, which supports [Android 1.5 (or higher)](Android.md).

**Other Java environments**

In addition to Android 1.5 or higher, the Google APIs Client Library for Java supports the following Java environments:
  * Java 5 (or higher), standard (SE) and enterprise (EE)
  * [Google App Engine](GoogleAppEngine.md)

Not supported: Google Web Toolkit (GWT), Java mobile (ME), and Java 1.4 (or earlier).

# Highlighted Features #
**The library makes it simple to call Google APIs.**

> You can call Google APIs using Google service-specific generated libraries with the Google APIs Client Library for Java. Here's an example that makes a call to the [Google Calendar API](https://developers.google.com/google-apps/calendar/):

```
  // Show events on user's calendar.
  View.header("Show Calendars");
  CalendarList feed = client.calendarList().list().execute();
  View.display(feed); 
```

**The library makes authentication easier.**

> The authentication library can reduce the amount of code needed to handle [OAuth 2.0](OAuth2.md), and sometimes a few lines is all you need. For example:

```
  /** Authorizes the installed application to access user's protected data. */
  private static Credential authorize() throws Exception {
    // load client secrets
    GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY,
        new InputStreamReader(CalendarSample.class.getResourceAsStream("/client_secrets.json")));
    // set up authorization code flow
    GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
        httpTransport, JSON_FACTORY, clientSecrets,
        Collections.singleton(CalendarScopes.CALENDAR)).setDataStoreFactory(dataStoreFactory)
        .build();
    // authorize
    return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
  } 
```
**The library makes batching and media upload/download easier.**

> The library offers helper classes for [batching](Batch.md), [media upload](MediaUpload.md), and [media download](MediaDownload.md).

**The library runs on Google App Engine.**

> [App Engine-specific helpers](GoogleAppEngine.md) make quick work of authenticated calls to APIs, and you do not need to worry about exchanging code for tokens. For example:

```
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    AppIdentityCredential credential =
        new AppIdentityCredential(Arrays.asList(UrlshortenerScopes.URLSHORTENER));
    Urlshortener shortener =
        new Urlshortener.Builder(new UrlFetchTransport(), new JacksonFactory(), credential)
        .build();
    UrlHistory history = shortener.URL().list().execute();
    ...
  } 
```

**The library runs on [Android (@Beta)](#@Beta.md).**

> If you are developing for Android and the Google API you want to use is included in the [Google Play Services library](https://developer.android.com/google/play-services/index.html), you should use that library for the best performance and experience.

> To access other Google APIs, you can use the Google Client Library for Java's Android-specific helper classes, which are are well-integrated with [Android AccountManager](http://developer.android.com/reference/android/accounts/AccountManager.html). For example:

```
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // Google Accounts
    credential =
        GoogleAccountCredential.usingOAuth2(this, Collections.singleton(TasksScopes.TASKS));
    SharedPreferences settings = getPreferences(Context.MODE_PRIVATE);
    credential.setSelectedAccountName(settings.getString(PREF_ACCOUNT_NAME, null));
    // Tasks client
    service =
        new com.google.api.services.tasks.Tasks.Builder(httpTransport, jsonFactory, credential)
            .setApplicationName("Google-TasksAndroidSample/1.0").build();
  } 
```

**The library is easy to install.**

> The Google APIs Client Library for Java is easy to install, and you can download the binary directly from the [Downloads page](Downloads.md), or you can use Maven or Gradle.
> To use Maven, add the following lines to your pom.xml file:

```
    <project>
      <dependencies>
        <dependency>
          <groupId>com.google.api-client</groupId>
          <artifactId>google-api-client</artifactId>
          <version>1.18.0-rc</version>
        </dependency>
      </dependencies>
    </project> 
```

> To use Gradle, add the following lines to your build.gradle file:

```
  repositories {
      mavenCentral()
  }
  dependencies {
      compile 'com.google.api-client:google-api-client:1.18.0-rc'
  }
```

# Dependencies #
This library is built on top of two common libraries, also built by Google, and also designed to work with any HTTP service on the web:
  * [Google HTTP Client Library for Java](http://code.google.com/p/google-http-java-client/)
  * [Google OAuth Client Library for Java](http://code.google.com/p/google-oauth-java-client/)

# Important Warnings #

## @Beta ##

Features marked with the @Beta annotation at the class or method level are subject to change. They might be modified in any way, or even removed, in any major release. You should not use beta features if your code is a library itself (that is, if your code is used on the CLASSPATH of users outside your own control).

## Deprecations ##

Deprecated non-beta features will be removed eighteen months after the release in which they are first deprecated. You must fix your usages before this time. If you don't, any type of breakage might result, and you are not guaranteed a compilation error.


<wiki:gadget url="https://google-code-feed-gadget.googlecode.com/svn/build/prod/feedgadget/feedgadget.xml" up\_feeds="https://google-api-java-client.blogspot.com/feeds/posts/default" width="500" height="340" border="0"/>