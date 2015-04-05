Google App Engine is one of the supported Java environments for the Google APIs Client Library for Java.

# Auth Helpers #

If you are building a web app that interacts with a user's data via an OAuth 2.0-enabled API, we've created some helpers to assist you with the process.  The helpers aim to:
  * Simplify the process of obtaining access tokens ([AuthorizationCodeFlow](http://javadoc.google-oauth-java-client.googlecode.com/hg/1.18.0-rc/com/google/api/client/auth/oauth2/AuthorizationCodeFlow.html)).
  * Manage tokens, after they are obtained, by marking them as [PersistenceCapable](https://developers.google.com/appengine/docs/java/datastore/jdo/dataclasses#Class_and_Field_Annotations).
  * Simplify the process of making authenticated calls using the access token's [credential](http://javadoc.google-oauth-java-client.googlecode.com/hg/1.18.0-rc/com/google/api/client/auth/oauth2/Credential.html).
  * Insulate you from the details of authentication when writing [servlets](http://javadoc.google-oauth-java-client.googlecode.com/hg/1.18.0-rc/com/google/api/client/extensions/appengine/auth/oauth2/package-summary.html).

# Getting Started #

  1. Install the Google APIs Client Library for Java:
    * Follow the [download instructions](Setup#Download_Library_with_Dependencies.md) and put the library .jar files into your war/WEB-INF/lib directory.
    * Alternatively, you can use [Maven](Setup#Maven.md).
  1. Learn about [using OAuth 2.0 with the authorization code flow for Google App Engine applications](OAuth2#Google_App_Engine_applications.md).
  1. Learn about [using OAuth 2.0 with the Google App Engine Identity API](OAuth2#Google_App_Engine_identity.md).
  1. Take a look at the [Calendar App Engine sample](http://samples.google-api-java-client.googlecode.com/hg/calendar-appengine-sample/instructions.html). This sample combines our Java library and auth helpers to show you how to access end-user data from within a Google App Engine web app. The sample also uses [GWT](http://www.gwtproject.org/) for the user interface.