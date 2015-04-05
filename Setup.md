You can download the Google APIs Client Library for Java and its dependencies in a zip file, or you can use Maven.


Also see the [ProGuard setup instructions](http://code.google.com/p/google-http-java-client/wiki/Setup#ProGuard) that are part of the Google HTTP Client Library for Java documentation.

# Download the Library with Dependencies #

Download the latest zip file, which you can find on the [Downloads page](Downloads.md), and extract it on your computer. This zip file contains the client library class .jar files and the associated source .jar files for each artifact and their dependencies. You can find dependency graphs and licenses for the different libraries in the dependencies folder. For more details about the contents of the download, see the readme.html file.

## Eclipse ##

If you use [Eclipse](http://www.eclipse.org), set the "Source attachment" for each class .jar file to its corresponding "-sources" .jar file.

## Android ##

If you are developing for Android and the Google API you want to use is included in the [Google Play Services library](https://developer.android.com/google/play-services/index.html), use that library for the best performance and experience.

If you are using the Google APIs Client Library for Java with Android, it is important to know which dependencies are compatible with Android, specifically which Android SDK level. Android applications require the following .jar files, or newer compatible versions, from the libs folder:
  * google-api-client-1.18.0-rc.jar
  * google-api-client-android-1.18.0-rc.jar
  * google-oauth-client-1.18.0-rc.jar
  * google-http-client-1.18.0-rc.jar
  * google-http-client-android-1.18.0-rc.jar
  * gson-2.1.jar
  * jackson-core-asl-1.9.11.jar
  * jackson-core-2.1.3.jar
  * jsr305-1.3.9.jar
  * protobuf-java-2.4.1.jar

**WARNING:** For Android, you MUST place the .jar files in a directory named "libs" so that the APK packager can find them.  Otherwise, you will get a `NoClassDefFoundError` error at runtime.

## Google App Engine ##

Google App Engine applications require the following .jar files, or newer compatible versions, from the libs folder:
  * google-api-client-1.18.0-rc.jar
  * google-api-client-appengine-1.18.0-rc.jar
  * google-api-client-servlet-1.18.0-rc.jar
  * google-oauth-client-1.18.0-rc.jar
  * google-oauth-client-appengine-1.18.0-rc.jar
  * google-oauth-client-servlet-1.18.0-rc.jar
  * google-http-client-1.18.0-rc.jar
  * google-http-client-appengine-1.18.0-rc.jar
  * gson-2.1.jar
  * jackson-core-asl-1.9.11.jar
  * jackson-core-2.1.3.jar
  * jdo2-api-2.3-eb.jar
  * jsr305-1.3.9.jar
  * protobuf-java-2.4.1.jar
  * transaction-api-1.1.jar
  * xpp3-1.1.4c.jar

## Servlet ##

Servlet applications require the following .jar files, or newer compatible versions, from the libs folder:
  * google-api-client-1.18.0-rc.jar
  * google-api-client-servlet-1.18.0-rc.jar
  * google-oauth-client-1.18.0-rc.jar
  * google-oauth-client-servlet-1.18.0-rc.jar
  * google-http-client-1.18.0-rc.jar
  * commons-logging-1.1.1.jar
  * gson-2.1.jar
  * httpclient-4.0.1.jar
  * httpcore-4.0.1.jar
  * jackson-core-asl-1.9.11.jar
  * jackson-core-2.1.3.jar
  * jdo2-api-2.3-eb.jar
  * jsr305-1.3.9.jar
  * protobuf-java-2.4.1.jar
  * transaction-api-1.1.jar
  * xpp3-1.1.4c.jar

## Generic Java ##

General purpose Java 5 applications require the following .jar files, or newer compatible versions, from the libs folder:
  * google-api-client-1.18.0-rc.jar
  * google-oauth-client-1.18.0-rc.jar
  * google-http-client-1.18.0-rc.jar
  * google-http-client-jackson2-1.18.0-rc.jar
  * commons-logging-1.1.1.jar
  * gson-2.1.jar
  * httpclient-4.0.1.jar
  * httpcore-4.0.1.jar
  * jackson-core-asl-1.9.11.jar
  * jackson-core-2.1.3.jar
  * jsr305-1.3.9.jar
  * protobuf-java-2.4.1.jar
  * xpp3-1.1.4c.jar

# Generated Libraries for Google APIs #

Take a look at the [setup instructions for the generated libraries for Google APIs](https://developers.google.com/api-client-library/java/apis/).

# Maven #

The Google APIs Client Library for Java is in the central [Maven](http://maven.apache.org) repository.  The Maven `groupId` for all artifacts for this library is `com.google.api-client`. Specific Maven instructions are given for each module (below).

If you use [Eclipse](http://www.eclipse.org), install the [Maven plugin](http://www.eclipse.org/m2e/). Also make sure to set your Eclipse preferences as follows:
  1. Within Eclipse, select **Window > Preferences** (or on Mac, **Eclipse > Preferences**).
  1. Select **Maven** and select the following options:
    * "Download Artifact Sources"
    * "Download Artifact JavaDoc"

# Google Plugin for Eclipse #

With Google Plugin for Eclipse 2.6, you can [add Google APIs to your App Engine or Android project](https://developers.google.com/eclipse/docs/googleapis). To do this:
  1. Within Eclipse, right-click on a project and select **Google > Add Google APIs**.
  1. Select the Google API you need from the list of available Google APIs.
  1. Click Finish.
Eclipse will automatically download the API client library (along with its dependencies and source) onto your project's classpath and into the war/WEB-INF/lib directory. It will provide you with update notifications when the Google API or the client library has been updated.

**WARNING:** Eclipse will show "Update available" when a newer version of the library is available.  To update, use the same **Google > Add Google APIs** utility.  Make sure to update all the Google API libraries on your project.  Also, you must remove any old versions of the .jar files that this tool updates in your war/WEB-INF/lib directory.

# Modules #

This library is composed of nine modules: [google-api-client](#google-api-client.md), [google-api-client-android](#google-api-client-android.md), [google-api-client-appengine](#google-api-client-appengine.md), [google-api-client-servlet](#google-api-client-servlet.md), [google-api-client-gson](#google-api-client-gson.md), [google-api-client-jackson2](#google-api-client-jackson2.md), [google-api-client-java6](#google-api-client-java6.md), [google-api-client-protobuf](#google-api-client-protobuf.md), and [google-api-client-xml](#google-api-client-xml.md).

## google-api-client ##

The Google HTTP Client Library for Java (google-api-client) is designed to be compatible with all supported Java platforms, including Android.

Maven usage:

```
<dependency>
  <groupId>com.google.api-client</groupId>
  <artifactId>google-api-client</artifactId>
  <version>1.18.0-rc</version>
</dependency>
```

On Android, you will need to explicitly exclude unused dependencies:

```
<dependency>
  <groupId>com.google.api-client</groupId>
  <artifactId>google-api-client</artifactId>
  <version>1.18.0-rc</version>
  <exclusions>
    <exclusion>
      <artifactId>xpp3</artifactId>
      <groupId>xpp3</groupId>
    </exclusion>
    <exclusion>
      <artifactId>httpclient</artifactId>
      <groupId>org.apache.httpcomponents</groupId>
    </exclusion>
    <exclusion>
      <artifactId>junit</artifactId>
      <groupId>junit</groupId>
    </exclusion>
    <exclusion>
      <artifactId>android</artifactId>
      <groupId>com.google.android</groupId>
    </exclusion>
  </exclusions>
</dependency>
```

## google-api-client-android ##

Extensions to the Google API Client Library for Java (google-api-client-android) support Java Google Android (only for SDK >= 2.1) applications.  This module depends on google-api-client and google-http-client-android.

Maven usage:

```
<dependency>
  <groupId>com.google.api-client</groupId>
  <artifactId>google-api-client-android</artifactId>
  <version>1.18.0-rc</version>
</dependency>
```

## google-api-client-servlet ##

Servlet and JDO extensions to the Google API Client Library for Java (google-api-client-servlet) support Java servlet web applications. This module depends on google-api-client and google-oauth-client-servlet.

Maven usage:

```
<dependency>
  <groupId>com.google.api-client</groupId>
  <artifactId>google-api-client-servlet</artifactId>
  <version>1.18.0-rc</version>
</dependency>
```

## google-api-client-appengine ##

Google App Engine extensions to the Google HTTP Client Library for Java (google-api-client-appengine) support Java Google App Engine applications.  This module depends on google-api-client, google-api-client-servlet, google-oauth-client-appengine and google-http-client-appengine.

Maven usage:

```
<dependency>
  <groupId>com.google.api-client</groupId>
  <artifactId>google-api-client-appengine</artifactId>
  <version>1.18.0-rc</version>
</dependency>
```

## google-api-client-gson ##
GSON extensions to the Google HTTP Client Library for Java (google-api-client-gson). This module depends on google-api-client and google-http-client-gson.

Maven usage:

```
<dependency>
  <groupId>com.google.api-client</groupId>
  <artifactId>google-api-client-gson</artifactId>
  <version>1.18.0-rc</version>
</dependency>
```

## google-api-client-jackson2 ##
Jackson2 extensions to the Google HTTP Client Library for Java (google-api-client-jackson2). This module depends on google-api-client and google-http-client-jackson2.

Maven usage:

```
<dependency>
  <groupId>com.google.api-client</groupId>
  <artifactId>google-api-client-jackson2</artifactId>
  <version>1.18.0-rc</version>
</dependency>
```

## google-api-client-java6 ##
Java 6 (and higher) extensions to the Google HTTP Client Library for Java (google-api-client-java6). This module depends on google-api-client and google-oauth-client-java6.

Maven usage:

```
<dependency>
  <groupId>com.google.api-client</groupId>
  <artifactId>google-api-client-java6</artifactId>
  <version>1.18.0-rc</version>
</dependency>
```

## google-api-client-protobuf ##
[Protocol buffer](https://developers.google.com/protocol-buffers/docs/overview) extensions to the Google HTTP Client Library for Java (google-api-client-protobuf). This module depends on google-http-client-protobuf and google-api-client.

Maven usage:

```
<dependency>
  <groupId>com.google.api-client</groupId>
  <artifactId>google-api-client-protobuf</artifactId>
  <version>1.18.0-rc</version>
</dependency>
```

## google-api-client-xml ##
XML extensions to the Google HTTP Client Library for Java (google-api-client-xml). This module depends on google-api-client and google-http-client-xml.

Maven usage:

```
<dependency>
  <groupId>com.google.api-client</groupId>
  <artifactId>google-api-client-xml</artifactId>
  <version>1.18.0-rc</version>
</dependency>
```