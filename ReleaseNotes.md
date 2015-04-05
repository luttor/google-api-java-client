

# Version 1.18.0-rc #

_April 10, 2014_

| [New Features in base library](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=milestone%3DVersion1.18.0+status%3DFixed&colspec=ID+Type+Priority+Summary&x=component&y=milestone&cells=tiles) | [JavaDoc](http://javadoc.google-api-java-client.googlecode.com/hg/1.18.0-rc/index.html) | [JDiff](http://javadoc.google-api-java-client.googlecode.com/hg/1.18.0-rc/jdiff/changes.html) |
|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# Version 1.16.0-rc #

_August 5, 2013_

| [New Features in base library](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=milestone%3DVersion1.16.0+status%3DFixed&colspec=ID+Type+Priority+Summary&x=component&y=milestone&cells=tiles) | [JavaDoc](http://javadoc.google-api-java-client.googlecode.com/hg/1.16.0-rc/index.html) | [JDiff](http://javadoc.google-api-java-client.googlecode.com/hg/1.16.0-rc/jdiff/changes.html) |
|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

Highlights:

  * [Updated to google-http-java-client version 1.16.0-rc](http://google-http-java-client.blogspot.com/2013/08/version-1160-rc-released.html)
  * [Updated to google-oauth-java-client version 1.16.0-rc](http://google-oauth-java-client.blogspot.com/2013/08/version-1160-rc-released.html)
  * [[Issue 783](https://code.google.com/p/google-api-java-client/issues/detail?id=783)] Created google-api-client-protobuf for the generated service-specific libraries based on the Protobuf format
  * [[Issue 772](https://code.google.com/p/google-api-java-client/issues/detail?id=772)] Fixed a bug where MediaHttpUploader.serverErrorCallback() would not work if the data was partially or fully uploaded
  * [[Issue 796](https://code.google.com/p/google-api-java-client/issues/detail?id=796)] Removed Beta API deprecated in 1.15 _(backwards incompatible change)_
  * [[Issue 530](https://code.google.com/p/google-api-java-client/issues/detail?id=530)] Added the App Engine test framework to google-api-client-appengine


# Version 1.15.0-rc #

_May 10, 2013_

| [New Features in base library](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=milestone%3DVersion1.15.0+status%3DFixed&colspec=ID+Type+Priority+Summary&x=component&y=milestone&cells=tiles) | [JavaDoc](http://javadoc.google-api-java-client.googlecode.com/hg/1.15.0-rc/index.html) | [JDiff](http://javadoc.google-api-java-client.googlecode.com/hg/1.15.0-rc/jdiff/changes.html) |
|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

Announcing the first release candidate of the Google API Java Client library!  The library is finally going out of beta.

Note that there are still some features of the library in active development that may require backwards incompatible changes in future releases before they are ready to fully go out of beta.  Each of these features is annotated with a @Beta tag.

In addition, the core and generated libraries have fully transitioned from our own Maven repository to the Central Maven Repository.
Users of older versions should remove the reference to our `<repository>` at `https://google-api-client-libraries.appspot.com/mavenrepo` in pom.xml, in order to fetch the latest version from the Central Repository.

Highlights:

  * Updated to [google-http-java-client version 1.15.0-rc](http://google-http-java-client.blogspot.com/2013/05/version-1150-rc-released.html)
  * Updated to [google-oauth-java-client version 1.15.0-rc](http://google-oauth-java-client.blogspot.com/2013/05/version-1150-rc-released.html)
  * [[Issue 686](https://code.google.com/p/google-api-java-client/issues/detail?id=686)]: Marked specific parts of the library as Beta
  * [[Issue 753](https://code.google.com/p/google-api-java-client/issues/detail?id=753)]: Removed deprecated API from 1.14 (backwards incompatible)
  * [[Issue 745](https://code.google.com/p/google-api-java-client/issues/detail?id=745)]: Added Google Compute Engine service accounts
  * [[Issue 755](https://code.google.com/p/google-api-java-client/issues/detail?id=755)]: Added ability to specify public certs URL for ID Token verification
  * [[Issue 734](https://code.google.com/p/google-api-java-client/issues/detail?id=734)]: Allowed exponential backoff behavior to be customized via backoff handlers.

# Version 1.14.1-beta #

_Mar 25, 2013_

| [New Features in base library](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=milestone%3DVersion1.14.0+status%3DFixed&colspec=ID+Type+Priority+Summary&x=component&y=milestone&cells=tiles) | [JavaDoc](http://javadoc.google-api-java-client.googlecode.com/hg/1.14.1-beta/index.html) | [JDiff](http://javadoc.google-api-java-client.googlecode.com/hg/1.14.1-beta/jdiff/changes.html) |
|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

Highlights:

  * Updated to [google-http-java-client version 1.14.1-beta](http://google-http-java-client.blogspot.com/2013/03/version-1141-beta-released.html)
  * Updated to [google-oauth-java-client version 1.14.1-beta](http://google-oauth-java-client.blogspot.com/2013/03/version-1141-beta-released.html)
  * [[Issue 685](http://code.google.com/p/google-api-java-client/issues/detail?id=685)]: Restrict trusted CAs to only those used by Google
  * [[Issue 705](http://code.google.com/p/google-api-java-client/issues/detail?id=705)]: Updated to the latest OpenID Connect specification
  * [[Issue 693](http://code.google.com/p/google-api-java-client/issues/detail?id=693)]: Now generate a BigInteger instead of UnsignedLong for uint64 _(backwards incompatible change)_
  * [[Issue 647](http://code.google.com/p/google-api-java-client/issues/detail?id=647)]: Added support for Google’s subscriptions protocol
  * [[Issue 650](http://code.google.com/p/google-api-java-client/issues/detail?id=650)]: Removed some deprecated API from 1.13 _(backwards incompatible change)_
  * [[Issue 708](http://code.google.com/p/google-api-java-client/issues/detail?id=708)]: Now uses supportsMediaDownload flag from Discovery to determine if a method supports media download
  * [[Issue 443](http://code.google.com/p/google-api-java-client/issues/detail?id=443)]: Fixed an issue where empty XScopes files were being generated
  * [[Issue 437](http://code.google.com/p/google-api-java-client/issues/detail?id=437)]: Added methods to decode and encode base64 data to generated classes
  * [[Issue 693](http://code.google.com/p/google-api-java-client/issues/detail?id=693)]: Generate a clone method in model classes
  * [[Issue 466](http://code.google.com/p/google-api-java-client/issues/detail?id=466)] and [[Issue 692](http://code.google.com/p/google-api-java-client/issues/detail?id=692)]: Now throw an exception if a required schema parameter isn’t specified or required content is missing
  * [[Issue 579](http://code.google.com/p/google-api-java-client/issues/detail?id=579)] and [[Issue 581](http://code.google.com/p/google-api-java-client/issues/detail?id=581)]: Fixed issues with resumable direct downloads and uploads
  * [[Issue 697](http://code.google.com/p/google-api-java-client/issues/detail?id=697)]: Renamed dependencies files to match package names.


# Version 1.13.2-beta #

_Jan 17, 2013_

| [New Features in base library](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=milestone%3DVersion1.13.0+status%3DFixed&colspec=ID+Type+Priority+Summary&x=component&y=milestone&cells=tiles) | [JavaDoc](http://javadoc.google-api-java-client.googlecode.com/hg/1.13.2-beta/index.html) | [JDiff](http://javadoc.google-api-java-client.googlecode.com/hg/1.13.2-beta/jdiff/changes.html) |
|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

Highlights:

  * Updated to [google-http-java-client version 1.13.1-beta](http://google-http-java-client.blogspot.com/2013/01/version-1131-beta-released.html)
  * Updated to [google-oauth-java-client version 1.13.1-beta](http://google-oauth-java-client.blogspot.com/2013/01/version-1131-beta-released.html)
  * [[Issue 673](http://code.google.com/p/google-api-java-client/issues/detail?id=673)] Fixed: NullPointerException on error when doing resumable media upload
  * [[Issue 663](http://code.google.com/p/google-api-java-client/issues/detail?id=663)] Fixed: range query request in MediaHttpUploader#serverErrorCallback fails with a 411
  * [[Issue 662](http://code.google.com/p/google-api-java-client/issues/detail?id=662)] MediaHttpUploader enforces that chunk sizes are multiples of 256KB
  * [[Issue 660](http://code.google.com/p/google-api-java-client/issues/detail?id=660)] Deprecated GoogleHeaders in preference of HttpHeaders, and deprecated GoogleUrl in preference of GenericUrl (backwards incompatible change)
  * [[Issue 653](http://code.google.com/p/google-api-java-client/issues/detail?id=653)] Change GET to POST if URI is too long
  * [[Issue 649](http://code.google.com/p/google-api-java-client/issues/detail?id=649)] Support PEM file format as input format for service accounts
  * [[Issue 641](http://code.google.com/p/google-api-java-client/issues/detail?id=641)] MediaHttpUploader: direct upload sets the request headers
  * [[Issue 638](http://code.google.com/p/google-api-java-client/issues/detail?id=638)] MediaHttpUploader now respects AbstractGoogleClientRequest.setDisableGZipContent(true)
  * [[Issue 634](http://code.google.com/p/google-api-java-client/issues/detail?id=634)] MediaHttpDownloader: added setContentRange
  * [[Issue 591](http://code.google.com/p/google-api-java-client/issues/detail?id=591)] MediaHttpUploader.upload() requires a known InputStreamContent size
  * AbstractGoogleClient now logs a warning if no application name has been set.

# Version 1.12.0-beta #

_Nov 8, 2012_

| [New Features in base library](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=milestone%3DVersion1.12.0+status%3DFixed&colspec=ID+Type+Priority+Summary&x=component&y=milestone&cells=tiles) | [JavaDoc](http://javadoc.google-api-java-client.googlecode.com/hg/1.12.0-beta/index.html) | [JDiff](http://javadoc.google-api-java-client.googlecode.com/hg/1.12.0-beta/jdiff/changes.html) |
|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

Highlights:

  * Updated to [google-http-java-client version 1.12](http://google-http-java-client.blogspot.com/2012/11/version-1120-beta-released_2495.html).
  * Updated to [google-oauth-java-client version 1.12](http://google-oauth-java-client.blogspot.com/2012/11/version-1120-beta-released.html).
  * Google API libraries version skipped from 1.9 to 1.12 so we can match the version of the core google-api-java-client library and thus reduce confusion.
  * Maven: repository URL of the Google API libraries has changed to http://google-api-client-libraries.appspot.com/mavenrepo
  * Updated [calendar-android-sample](http://samples.google-api-java-client.googlecode.com/hg/calendar-android-sample/instructions.html) and [tasks-android-sample](http://samples.google-api-java-client.googlecode.com/hg/tasks-android-sample/instructions.html) to demonstrate best practice of using Google Play services for OAuth 2.
  * [[Issue 629](http://code.google.com/p/google-api-java-client/issues/detail?id=629)] Fixed the 411 Length Required error in custom PUT methods.
  * [[Issue 561](http://code.google.com/p/google-api-java-client/issues/detail?id=561)] Added [GoogleAccountCredential](http://javadoc.google-api-java-client.googlecode.com/hg/1.12.0-beta/com/google/api/client/googleapis/extensions/android/gms/auth/GoogleAccountCredential.html) for Android.
  * [[Issue 55](http://code.google.com/p/google-oauth-java-client/issues/detail?id=55)] Fixed [FileCredentialStore](http://javadoc.google-oauth-java-client.googlecode.com/hg/1.12.0-beta/com/google/api/client/extensions/java6/auth/oauth2/FileCredentialStore.html) failure on Windows.
  * [[Issue 601](http://code.google.com/p/google-api-java-client/issues/detail?id=601)] Service-specific Eclipse Android properties file has been added.
  * [[Issue 642](http://code.google.com/p/google-api-java-client/issues/detail?id=642)] Fixed classpath entries in the generated libraries manifest.
  * [[Issue 643](http://code.google.com/p/google-api-java-client/issues/detail?id=643)] Using wrong version of the core library now throws an Error.
  * [[Issue 645](http://code.google.com/p/google-api-java-client/issues/detail?id=645)] setXYZRequestInitializer has been added to the generated libraries Builder.
  * [[Issue 622](http://code.google.com/p/google-api-java-client/issues/detail?id=622)] Can now execute using HEAD.
  * [[Issue 220](http://code.google.com/p/google-api-java-client/issues/detail?id=220)] Added support for non-json alt types.

# Version 1.11.0-beta #

_Sept 25, 2012_

| [New Features in base library](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=milestone%3DVersion1.11.0+status%3DFixed&colspec=ID+Type+Priority+Summary&x=component&y=milestone&cells=tiles) | [New Features in generated library](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=Milestone%3DCodeGenVersion1.8.0+status%3DFixed&colspec=ID+Type+Priority+Summary) | [JavaDoc](http://javadoc.google-api-java-client.googlecode.com/hg/1.11.0-beta/index.html) | [JDiff](http://javadoc.google-api-java-client.googlecode.com/hg/1.11.0-beta/jdiff/changes.html) |
|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

Highlights:

  * [[Issue 574](http://code.google.com/p/google-api-java-client/issues/detail?id=574)] Removed deprecated classes/methods/fields from version 1.10.
  * [[Issue 310](http://code.google.com/p/google-api-java-client/issues/detail?id=310)] Added command line auth helpers to google-api-java-client.
  * [[Issue 594](http://code.google.com/p/google-api-java-client/issues/detail?id=594)] Renamed g-a-c-android2 to g-a-c-android.
  * [[Issue 597](http://code.google.com/p/google-api-java-client/issues/detail?id=597)] Created properties files for Eclipse Android support.
  * [[Issue 389](http://code.google.com/p/google-api-java-client/issues/detail?id=389)] Added support for UnsignedLong in service-specific libraries
  * [[Issue 583](http://code.google.com/p/google-api-java-client/issues/detail?id=583)] DateTime is now used for “date” values in service-specific libraries
  * [[Issue 525](http://code.google.com/p/google-api-java-client/issues/detail?id=525)] Added support for redirects in BatchRequest.
  * [[Issue 560](http://code.google.com/p/google-api-java-client/issues/detail?id=560)] Batch now adds authorization to the top-level request.
  * Updated to google-http-java-client version 1.11.
  * Updated to google-oauth-java-client version 1.11.

# Version 1.10.3-beta #

_June 25, 2012_

| [Bugs Fixed](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=milestone=Version1.10.3%20status=Fixed&colspec=ID%20Type%20Priority%20Summary) | [JavaDoc](http://javadoc.google-api-java-client.googlecode.com/hg/1.10.3-beta/index.html) | [JDiff](http://javadoc.google-api-java-client.googlecode.com/hg/1.10.3-beta/jdiff/changes.html) |
|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

[Bugs Fixed](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=milestone=Version1.10.3%20status=Fixed&colspec=ID%20Type%20Priority%20Summary):<br />
Issue [527](http://code.google.com/p/google-api-java-client/issues/detail?id=527): Proguard does not strip out GoogleJsonError.ErrorInfo anymore.<br />
Issue [528](http://code.google.com/p/google-api-java-client/issues/detail?id=528): Proguard does not strip out model. anymore.<br />
Updated to google-http-java-client version 1.10.3-beta.<br />
Updated to google-oauth-java-client version 1.10.1-beta.<br />


# Version 1.10.2-beta #

_June 18, 2012_

| [Bugs Fixed](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=milestone=Version1.10.2%20status=Fixed&colspec=ID%20Type%20Priority%20Summary) | [JavaDoc](http://javadoc.google-api-java-client.googlecode.com/hg/1.10.2-beta/index.html) | [JDiff](http://javadoc.google-api-java-client.googlecode.com/hg/1.10.2-beta/jdiff/changes.html) |
|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

[Bugs Fixed](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=milestone=Version1.10.2%20status=Fixed&colspec=ID%20Type%20Priority%20Summary):<br />
Issue [521](http://code.google.com/p/google-api-java-client/issues/detail?id=521): Fixed resumable upload failure when writing multiple chunks.<br />
Issue [512](http://code.google.com/p/google-api-java-client/issues/detail?id=512): Added exponential backoff to Batch.<br />

# Version 1.10.1-beta #

_June 14, 2012_

| [New Features in base library](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=milestone%3DVersion1.10.0+status%3DFixed&colspec=ID+Type+Priority+Summary&x=component&y=milestone&cells=tiles) | [New Features in generated library](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=Milestone%3DCodeGenVersion1.7.0+status%3DFixed&colspec=ID+Type+Priority+Summary) | [JavaDoc](http://javadoc.google-api-java-client.googlecode.com/hg/1.10.1-beta/index.html) | [JDiff](http://javadoc.google-api-java-client.googlecode.com/hg/1.10.1-beta/jdiff/changes.html) |
|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

Highlights:
  * [[Issue 516](http://code.google.com/p/google-api-java-client/issues/detail?id=516)] Changed accessType and approvalPrompt defaults in GoogleAuthorizationCodeFlow.
  * [[Issue 402](http://code.google.com/p/google-api-java-client/issues/detail?id=402)] Fixed memory leaks.
  * [[Issue 125](http://code.google.com/p/google-http-java-client/issues/detail?id=125)] Fixed issue of creating UrlFetchTransport in GAE SDK 1.6.6 in google-http-java-client.
  * [[Issue 116](http://code.google.com/p/google-http-java-client/issues/detail?id=116)] Fixed CloseGuard error after EOFException in google-http-java-client.
  * [[Issue 78](http://code.google.com/p/google-http-java-client/issues/detail?id=78)] Fixed memory leaks in google-http-java-client.
  * [[Issue 118](http://code.google.com/p/google-http-java-client/issues/detail?id=118)] UriTemplate.expand now supports Iterable for list parameters in google-http-java-client.
  * [[Issue 514](http://code.google.com/p/google-api-java-client/issues/detail?id=514)] Added HttpRequestInitializer to constructor and Builder of generated service-specific libraries.
  * [[Issue 511](http://code.google.com/p/google-api-java-client/issues/detail?id=511)] Moved enableGZipContent to JsonHttpRequest and removed builder() methods.
  * [[Issue 500](http://code.google.com/p/google-api-java-client/issues/detail?id=500)] Updated GoogleClient to use rootUrl and servicePath.
  * Improvements to the surface of the service-specific generated libraries:
    * [[Issue 505](http://code.google.com/p/google-api-java-client/issues/detail?id=505)] New structure for jars in zip package of generated libraries.
    * [[Issue 483](http://code.google.com/p/google-api-java-client/issues/detail?id=483)] setFields are now overridden.
    * [[Issue 387](http://code.google.com/p/google-api-java-client/issues/detail?id=387)] Created an isX() method for boolean parameters.
    * [[Issue 515](http://code.google.com/p/google-api-java-client/issues/detail?id=515)] Generated service-specific libraries now use rootUrl rather than baseUrl.
    * [[Issue 518](http://code.google.com/p/google-api-java-client/issues/detail?id=518)] Added Maven archtype catalog.
  * Updated to google-http-java-client version 1.10.
  * Updated to google-oauth-java-client version 1.10.

# Version 1.9.0-beta #

_May 18, 2012_

| [New Features in base library](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=milestone%3DVersion1.9.0+status%3DFixed&colspec=ID+Type+Priority+Summary&x=component&y=milestone&cells=tiles) | [New Features in generated library](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=Milestone%3DCodeGenVersion1.6.0+status%3DFixed&colspec=ID+Type+Priority+Summary) | [JavaDoc](http://javadoc.google-api-java-client.googlecode.com/hg/1.9.0-beta/index.html) | [JDiff](http://javadoc.google-api-java-client.googlecode.com/hg/1.9.0-beta/jdiff/changes.html) |
|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

Highlights:
  * [[Issue 308](http://code.google.com/p/google-api-java-client/issues/detail?id=308)] Added support for [Batch](http://code.google.com/p/google-api-java-client/wiki/Batch).
  * [[Issue 448](http://code.google.com/p/google-api-java-client/issues/detail?id=448)] Added support for [Resumable Media Download](http://code.google.com/p/google-api-java-client/wiki/MediaDownload#Resumable_Media_Download).
  * [[Issue 391](http://code.google.com/p/google-api-java-client/issues/detail?id=391)] Added support for [Direct Media Upload](http://code.google.com/p/google-api-java-client/wiki/MediaUpload#Direct_Media_Upload).
  * [[Issue 459](http://code.google.com/p/google-api-java-client/issues/detail?id=459)] [GoogleIdTokenVerifier](http://javadoc.google-api-java-client.googlecode.com/hg/1.9.0-beta/com/google/api/client/googleapis/auth/oauth2/GoogleIdTokenVerifier.html) now has support for specifying multiple client ids.
  * [[Issue 452](http://code.google.com/p/google-api-java-client/issues/detail?id=452)] Handled connection errors in [MediaHttpUploader](http://javadoc.google-api-java-client.googlecode.com/hg/1.9.0-beta/com/google/api/client/googleapis/media/MediaHttpUploader.html).
  * [[Issue 473](http://code.google.com/p/google-api-java-client/issues/detail?id=473)] [MediaHttpUploader](http://javadoc.google-api-java-client.googlecode.com/hg/1.9.0-beta/com/google/api/client/googleapis/media/MediaHttpUploader.html) now handles input streams that do not support mark().
  * Improvements to the surface of the service-specific generated libraries:
    * [[Issue 215](http://code.google.com/p/google-api-java-client/issues/detail?id=215)] Added support for specifying HTTP headers on a request.
    * [[Issue 346](http://code.google.com/p/google-api-java-client/issues/detail?id=346)] Handled case where default value for alt parameter is not json.
    * [[Issue 489](http://code.google.com/p/google-api-java-client/issues/detail?id=489)] Fixed compilation error when method names are the same name as the collection.
    * [[Issue 490](http://code.google.com/p/google-api-java-client/issues/detail?id=490)] Fixed compilation error when deeply nested classes have the same name as one of its ancestors.
  * [[Issue 480](http://code.google.com/p/google-api-java-client/issues/detail?id=480)] Removed xpp3 as a dependency for Android.
  * [[Issue 461](http://code.google.com/p/google-api-java-client/issues/detail?id=461)] Generalized dependency instructions for non-Android.
  * [[Issue 487](http://code.google.com/p/google-api-java-client/issues/detail?id=487)] Created new structure for jars in the zip package.
  * [[Issue 471](http://code.google.com/p/google-api-java-client/issues/detail?id=471)] Removed deprecated classes/methods/fields from version 1.8.
  * Updated to [google-http-java-client version 1.9](http://google-http-java-client.blogspot.com/2012/05/version-190-beta-released.html).
  * Updated to [google-oauth-java-client version 1.9](http://google-oauth-java-client.blogspot.com/2012/05/version-190-beta-released.html).

# Version 1.8.0-beta #

_April 4, 2012_

| [New Features in base library](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=milestone%3DVersion1.8.0+status%3DFixed&colspec=ID+Type+Priority+Summary&x=component&y=milestone&cells=tiles) | [New Features in generated library](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=Milestone%3DCodeGenVersion1.5.0+status%3DFixed&colspec=ID+Type+Priority+Summary) | [JavaDoc](http://javadoc.google-api-java-client.googlecode.com/hg/1.8.0-beta/index.html) | [JDiff](http://javadoc.google-api-java-client.googlecode.com/hg/1.8.0-beta/jdiff/changes.html) |
|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

Highlights:
  * Improvements to the surface of the service-specific generated libraries:
    * [[Issue 434](http://code.google.com/p/google-api-java-client/issues/detail?id=434)] Added support for direct media download.
    * [[Issue 444](http://code.google.com/p/google-api-java-client/issues/detail?id=444)] Resumable media upload now uses the base URL set through builder.setBaseUrl.
  * [[Issue 436](http://code.google.com/p/google-api-java-client/issues/detail?id=436)] [GoogleKeyInitializer](http://javadoc.google-api-java-client.googlecode.com/hg/1.8.0-beta/com/google/api/client/googleapis/services/GoogleKeyInitializer.html) has been added.
  * [[Issue 440](http://code.google.com/p/google-api-java-client/issues/detail?id=440)] [GoogleJsonResponseException](http://javadoc.google-api-java-client.googlecode.com/hg/1.8.0-beta/com/google/api/client/googleapis/json/GoogleJsonResponseException.html) no longer throws an NPE when the response has no content.
  * [[Issue 430](http://code.google.com/p/google-api-java-client/issues/detail?id=430)] [GoogleIdTokenVerifier](http://javadoc.google-api-java-client.googlecode.com/hg/1.8.0-beta/com/google/api/client/googleapis/auth/oauth2/GoogleIdTokenVerifier.html) now supports arbitary client\_ids.
  * [[Issue 431](http://code.google.com/p/google-api-java-client/issues/detail?id=431)] [AppIdentityCredential.intercept](http://javadoc.google-api-java-client.googlecode.com/hg/1.8.0-beta/com/google/api/client/googleapis/extensions/appengine/auth/oauth2/AppIdentityCredential.html#intercept(com.google.api.client.http.HttpRequest)) now throws IOException on AppIdentityServiceFailureException.
  * [[Issue 145](http://code.google.com/p/google-api-java-client/issues/detail?id=145)] Constructors that take required parameters for compile-time checking.
  * [[Issue 432](http://code.google.com/p/google-api-java-client/issues/detail?id=432)] Some deprecated classes/methods/fields from version 1.7 have been removed.
  * Updated to [google-http-java-client version 1.8](http://google-http-java-client.blogspot.com/2012/04/version-183-beta-released.html).
  * Updated to [google-oauth-java-client version 1.8](http://google-oauth-java-client.blogspot.com/2012/04/version-180-beta-released.html).

# Version 1.7.0-beta #

_Mar 12, 2012_

| [New Features in base library](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=milestone%3DVersion1.7.0+status%3DFixed&colspec=ID+Type+Priority+Summary&x=component&y=milestone&cells=tiles) | [New Features in generated library](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=Milestone%3DCodeGenVersion1.4.0+status%3DFixed&colspec=ID+Type+Priority+Summary) | [JavaDoc](http://javadoc.google-api-java-client.googlecode.com/hg/1.7.0-beta/index.html) | [JDiff](http://javadoc.google-api-java-client.googlecode.com/hg/1.7.0-beta/jdiff/changes.html) |
|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

Highlights:
  * [[Issue 2](http://code.google.com/p/google-api-java-client/issues/detail?id=2)] Resumable media upload is now supported.
  * [[Issue 365](http://code.google.com/p/google-api-java-client/issues/detail?id=365)] Updated to the latest [OAuth 2.0](http://code.google.com/p/google-api-java-client/wiki/OAuth2) (draft 23).
  * [[Issue 338](http://code.google.com/p/google-api-java-client/issues/detail?id=338)] Support for client\_secrets.json has been added.
  * [[Issue 406](http://code.google.com/p/google-api-java-client/issues/detail?id=406)] Google ID Tokens based on JSON Web Tokens is now supported.
  * [[Issue 321](http://code.google.com/p/google-api-java-client/issues/detail?id=321)] Asserting identity on Google App Engine to Google APIs is now supported.
  * [[Issue 140](http://code.google.com/p/google-api-java-client/issues/detail?id=140)] Exponential backoff is now supported.
  * Improvements to the surface of the service-specific generated libraries:
    * [[Issue 306](http://code.google.com/p/google-api-java-client/issues/detail?id=306)] Top level schema classes which are arrays are now generated correctly.
    * [[Issue 304](http://code.google.com/p/google-api-java-client/issues/detail?id=304)] Inner classes for unnamed objects.
    * [[Issue 359](http://code.google.com/p/google-api-java-client/issues/detail?id=359)] OAuth 2.0 scopes are now generated.
    * Library version now includes a revision number, e.g. “rev2”, that indicates a revision of the API without changing the version.
  * [[Issue 407](http://code.google.com/p/google-api-java-client/issues/detail?id=407)] Split and renamed extension projects to be more intuitive.
  * [[Issue 352](http://code.google.com/p/google-api-java-client/issues/detail?id=352)] Deprecated classes/methods/fields from version 1.6 have been removed.
  * Updated to [google-http-java-client version 1.7](http://google-http-java-client.blogspot.com/2012/03/version-170-beta-released.html).
  * Updated to [google-oauth-java-client version 1.7](http://google-oauth-java-client.blogspot.com/2012/03/version-170-beta-released.html).

# Version 1.6.0-beta #

_Nov 8, 2011_

| [New Features in base library](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=milestone%3DVersion1.6.0+status%3DFixed&colspec=ID+Type+Priority+Summary&x=component&y=milestone&cells=tiles) | [New Features in generated library](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=Milestone%3DCodeGenVersion1.3.0+status%3DFixed&colspec=ID+Type+Priority+Summary) | [JavaDoc](http://javadoc.google-api-java-client.googlecode.com/hg/1.6.0-beta/index.html) | [JDiff](http://javadoc.google-api-java-client.googlecode.com/hg/1.6.0-beta/jdiff/changes.html) |
|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

Highlights:
  * Many improvements to the surface of the generated libraries. Improvements are listed [here](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=Milestone%3DCodeGenVersion1.3.0+status%3DFixed&colspec=ID+Type+Priority+Summary).
    * The service-specific client now adheres to the Builder pattern to follow our thread-safety style guidelines.
    * The global parameters (prettyPrint, fields, keys etc) are now generated in a service-specific class that extends [JsonHttpRequest](http://javadoc.google-http-java-client.googlecode.com/hg/1.6.0-beta/com/google/api/client/http/json/JsonHttpRequest.html) and are initialized with [JsonHttpRequestInitializer](http://javadoc.google-http-java-client.googlecode.com/hg/1.6.0-beta/com/google/api/client/http/json/JsonHttpRequestInitializer.html).
  * Better exception model by introducing [GoogleJsonResponseException](http://javadoc.google-api-java-client.googlecode.com/hg/1.6.0-beta/com/google/api/client/googleapis/json/GoogleJsonResponseException.html).
  * Updated to [google-http-java-client](http://code.google.com/p/google-http-java-client/wiki/ReleaseNotes#Version_1.6.0-beta) version 1.6.
  * Updated to [google-oauth-java-client](http://code.google.com/p/google-oauth-java-client/wiki/ReleaseNotes#Version_1.6.0-beta) version 1.6.
  * All [samples](http://code.google.com/p/google-api-java-client/source/browse/?repo=samples) have been updated.

# Version 1.5.1-beta #

_Oct 25, 2011_

| [Bugs Fixed](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=milestone=Version1.5.1%20status=Fixed&colspec=ID%20Type%20Priority%20Summary) | [JavaDoc](http://javadoc.google-api-java-client.googlecode.com/hg/1.5.1-beta/index.html) | [JDiff](http://javadoc.google-api-java-client.googlecode.com/hg/1.5.1-beta/jdiff/changes.html) |
|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

[Bugs Fixed](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=milestone=Version1.5.1%20status=Fixed&colspec=ID%20Type%20Priority%20Summary):<br />
Issue [329](http://code.google.com/p/google-api-java-client/issues/detail?id=329): Update pom.xml to point to google-http-java-client 1.5.3-beta and google-oauth-java-client 1.5.2-beta<br />
Issue [325](http://code.google.com/p/google-api-java-client/issues/detail?id=325): Add Javadoc that refreshToken can be null in GoogleAccessProtectedResource<br />
Please take a look at the [JavaDoc](http://javadoc.google-api-java-client.googlecode.com/hg/1.5.1-beta/index.html).


---


# Version 1.5.0-beta #

_Sep 19, 2011_

| [New Features](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=milestone=Version1.5.0%20status=Fixed&colspec=ID%20Type%20Priority%20Summary) | [JavaDoc](http://javadoc.google-api-java-client.googlecode.com/hg/1.5.0-beta/index.html) | [JDiff](http://javadoc.google-api-java-client.googlecode.com/hg/1.5.0-beta/jdiff/changes.html) |
|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

Announcing the release of the new [Google HTTP Client Library for Java](http://code.google.com/p/google-http-java-client) and [Google OAuth Client Library for Java](http://code.google.com/p/google-oauth-java-client) split off from the [Google API Client Library for Java](http://code.google.com/p/google-api-java-client)!  These are the core package that work with any HTTP REST, OAuth 1.0a or OAuth 2.0 (draft 10) service on the web.

For more details, please take a look at our blog post on the Google Code Blog ["Google APIs Client Library for Java: now with OAuth 2.0"](http://googlecode.blogspot.com/2011/09/google-apis-client-library-for-java-now.html).


---


# Version 1.4.1-beta #

_May 7, 2011_

| [JavaDoc](http://javadoc.google-api-java-client.googlecode.com/hg/1.4.1-beta/index.html) | [JDiff relative to 1.3.2-alpha](http://javadoc.google-api-java-client.googlecode.com/hg/1.4.1-beta/jdiff/changes.html) | [New Features](http://code.google.com/p/google-api-java-client/issues/list?can=1&q=milestone%3DVersion1.4.0+status%3DFixed&colspec=ID+Type+Priority+Summary&x=component&y=milestone&cells=tiles) | [Compatibility notes with 1.3](http://google-api-java-client.googlecode.com/hg/google-api-client-assembly/readme.html) |
|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

Highlights:
  * [Generated libraries for Google APIs](http://code.google.com/p/google-api-java-client/wiki/Setup#Generated_libraries_for_Google_APIs) based on the new Google API infrastructure, like Google Buzz.
  * Better OAuth 2.0 support, including ability to [refresh expired tokens](http://javadoc.google-api-java-client.googlecode.com/hg/1.4.1-beta/com/google/api/client/googleapis/auth/oauth2/draft10/GoogleAccessProtectedResource.html), and [servlet-based 3-legged flows](http://javadoc.google-api-java-client.googlecode.com/hg/1.4.1-beta/com/google/api/client/googleapis/extensions/auth/helpers/oauth2/draft10/GoogleOAuth2ThreeLeggedFlow.html) that persist credentials
  * Smarter data model that supports Java features like enums,  generic types, and primitive arrays, as well as support for JSON nulls
  * [Android JSON Factory](http://javadoc.google-api-java-client.googlecode.com/hg/1.4.1-beta/com/google/api/client/extensions/android3/json/AndroidJsonFactory.html) implementation that works with the built-in streaming JSON library on Honeycomb (SDK 3.0) or higher.