# Legacy Support for ClientLogin #
ClientLogin is a [deprecated](https://developers.google.com/accounts/docs/AuthForInstalledApps?csw=1) authentication protocol used by older Google APIs, and support for it will be removed from the Google APIs Client Library for Java.

**Do not use ClientLogin for new applications.** Instead, use the more secure [OAuth 2.0](OAuth2.md) authentication protocol. 

**If your existing application uses ClientLogin**, we encourage you to migrate to OAuth 2.0 as soon as possible. For information about how ClientLogin is implemented within the Google APIs Client Library for Java, see the [ClientLogin JavaDoc](http://javadoc.google-api-java-client.googlecode.com/hg/1.18.0-rc/com/google/api/client/googleapis/auth/clientlogin/package-summary.html) ([@Beta](https://code.google.com/p/google-api-java-client/#@Beta)). For general instructions, see [ClientLogin for Installed Applications](http://code.google.com/apis/accounts/docs/AuthForInstalledApps.html).

# Sample Program #
The following sample program shows ClientLogin used for authentication. You must manually fill in the username and password in order for this sample to work.  Otherwise, you will likely get an HTTP `403 Forbidden` status code.

Do not base new work on the sample; it is provided only for ClientLogin legacy support.

```
import com.google.api.client.googleapis.auth.clientlogin.ClientLogin;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.io.IOException;
import java.lang.System;

public class ClientLoginSample {
  public static void main(String[] args) throws IOException {
    // HttpTransport used to send login request.
    HttpTransport transport = new NetHttpTransport();
    try {
      // authenticate with ClientLogin
      ClientLogin authenticator = new ClientLogin();
      authenticator.transport = transport;
      // Google service trying to access, e.g., "cl" for calendar.
      authenticator.authTokenType = "cl";
      authenticator.username = "username";
      authenticator.password = "password";
      authenticator.authenticate();
      System.out.println("Authentication succeeded.");
    } catch (HttpResponseException e) {
      // Likely a "403 Forbidden" error.
      System.err.println(e.getStatusMessage());
      throw e;
    }
  }
}
```