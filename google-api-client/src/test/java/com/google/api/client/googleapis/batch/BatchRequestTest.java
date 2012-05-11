// Copyright 2012 Google Inc. All Rights Reserved.

package com.google.api.client.googleapis.batch;

import com.google.api.client.googleapis.GoogleHeaders;
import com.google.api.client.googleapis.batch.BatchRequest.RequestInfo;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonError.ErrorInfo;
import com.google.api.client.googleapis.json.GoogleJsonErrorContainer;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpMethod;
import com.google.api.client.http.HttpParser;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.http.json.JsonHttpClient;
import com.google.api.client.http.json.JsonHttpParser;
import com.google.api.client.http.json.JsonHttpRequest;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.client.util.Key;

import junit.framework.TestCase;

import java.io.IOException;
import java.util.List;

/**
 * Tests {@link BatchRequest}.
 *
 * @author rmistry@google.com (Ravi Mistry)
 */
public class BatchRequestTest extends TestCase {

  private static final String BASE_URL = "http://www.test.com/";
  private static final String TEST_BATCH_URL = "http://www.testgoogleapis.com/batch";
  private static final String URI_TEMPLATE1 = "uri/template/1";
  private static final String URI_TEMPLATE2 = "uri/template/2";
  private static final HttpMethod METHOD1 = HttpMethod.GET;
  private static final HttpMethod METHOD2 = HttpMethod.POST;
  private static final String ERROR_MSG = "Error message";
  private static final String ERROR_REASON = "notFound";
  private static final int ERROR_CODE = 404;
  private static final String ERROR_DOMAIN = "global";
  private static final String RESPONSE_BOUNDARY = "ABCDEF";
  private static final String TEST_ID = "Humpty Dumpty";
  private static final String TEST_KIND = "Big Egg";
  private static final String TEST_NAME = "James Bond";
  private static final String TEST_NUM = "007";

  private TestCallback1 callback1;
  private TestCallback2 callback2;
  private TestCallback3 callback3;

  @Override
  protected void setUp() {
    callback1 = new TestCallback1();
    callback2 = new TestCallback2();
    callback3 = new TestCallback3();
  }

  public static class MockDataClass1 extends GenericJson {
    @Key
    String id;

    @Key
    String kind;
  }

  public static class MockDataClass2 extends GenericJson {
    @Key
    String name;

    @Key
    String number;
  }

  private static class TestCallback1
      implements
        BatchCallback<MockDataClass1, GoogleJsonErrorContainer> {

    int successCalls;

    TestCallback1() {
    }

    public void onSuccess(MockDataClass1 dataClass, GoogleHeaders responseHeaders) {
      successCalls++;
      assertEquals(TEST_ID, dataClass.id);
      assertEquals(TEST_KIND, dataClass.kind);
    }

    public void onFailure(GoogleJsonErrorContainer e, GoogleHeaders responseHeaders) {
      fail("Should not be invoked in this test");
    }
  }

  private static class TestCallback2
      implements
        BatchCallback<MockDataClass2, GoogleJsonErrorContainer> {

    int successCalls;
    int failureCalls;

    TestCallback2() {
    }

    public void onSuccess(MockDataClass2 dataClass, GoogleHeaders responseHeaders) {
      successCalls++;
      assertEquals(TEST_NAME, dataClass.name);
      assertEquals(TEST_NUM, dataClass.number);
    }

    public void onFailure(GoogleJsonErrorContainer e, GoogleHeaders responseHeaders) {
      failureCalls++;
      GoogleJsonError error = e.getError();
      ErrorInfo errorInfo = error.getErrors().get(0);
      assertEquals(ERROR_DOMAIN, errorInfo.getDomain());
      assertEquals(ERROR_REASON, errorInfo.getReason());
      assertEquals(ERROR_MSG, errorInfo.getMessage());
      assertEquals(ERROR_CODE, error.getCode());
      assertEquals(ERROR_MSG, error.getMessage());
    }
  }

  private static class TestCallback3 implements BatchCallback<Void, Void> {

    int successCalls;
    int failureCalls;

    TestCallback3() {
    }

    public void onSuccess(Void dataClass, GoogleHeaders responseHeaders) {
      successCalls++;
      assertNull(dataClass);
    }

    public void onFailure(Void e, GoogleHeaders responseHeaders) {
      failureCalls++;
      assertNull(e);
    }
  }

  private static class MockUnsuccessfulResponseHandler implements HttpUnsuccessfulResponseHandler {

    MockTransport transport;
    boolean returnSuccessAuthenticatedContent;

    MockUnsuccessfulResponseHandler(
        MockTransport transport, boolean returnSuccessAuthenticatedContent) {
      this.transport = transport;
      this.returnSuccessAuthenticatedContent = returnSuccessAuthenticatedContent;
    }

    public boolean handleResponse(
        HttpRequest request, HttpResponse response, boolean supportsRetry) {
      if (transport.returnErrorAuthenticatedContent) {
        // If transport has already been set to return error content do not handle response.
        return false;
      }
      if (returnSuccessAuthenticatedContent) {
        transport.returnSuccessAuthenticatedContent = true;
      } else {
        transport.returnErrorAuthenticatedContent = true;
      }
      return true;
    }

  }

  private static class MockTransport extends MockHttpTransport {

    boolean testServerError;
    boolean testAuthenticationError;
    boolean returnSuccessAuthenticatedContent;
    boolean returnErrorAuthenticatedContent;

    MockTransport(boolean testServerError, boolean testAuthenticationError) {
      this.testServerError = testServerError;
      this.testAuthenticationError = testAuthenticationError;
    }

    @Override
    public LowLevelHttpRequest buildPostRequest(String url) {
      return new MockLowLevelHttpRequest() {
          @Override
        public LowLevelHttpResponse execute() {
          MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
          response.setStatusCode(200);
          response.addHeader("Content-Type", "multipart/mixed; boundary=" + RESPONSE_BOUNDARY);
          String content1 = "{\n \"id\": \"" + TEST_ID + "\",\n \"kind\": \"" + TEST_KIND + "\"\n}";
          String content2 = "{\"name\": \"" + TEST_NAME + "\", \"number\": \"" + TEST_NUM + "\"}";

          StringBuilder responseContent = new StringBuilder();
          if (returnSuccessAuthenticatedContent) {
            responseContent.append("--" + RESPONSE_BOUNDARY + "\n")
                    .append("Content-Type: application/http\n")
                    .append("Content-Transfer-Encoding: binary\n")
                    .append("Content-ID: response-1\n\n")
                    .append("HTTP/1.1 200 OK\n")
                    .append("Content-Type: application/json; charset=UTF-8\n")
                    .append("Content-Length: " + content2.length() + "\n\n")
                    .append(content2 + "\n\n")
                    .append("--" + RESPONSE_BOUNDARY + "--\n\n");
          } else if (returnErrorAuthenticatedContent) {
            responseContent.append(
                "Content-Type: application/http\n")
                .append("Content-Transfer-Encoding: binary\n").append("Content-ID: response-1\n\n");
            String errorContent = new StringBuilder().append(
                "{\"error\": { \"errors\": [{\"domain\": \"" + ERROR_DOMAIN + "\",").append(
                "\"reason\": \"" + ERROR_REASON + "\", \"message\": \"" + ERROR_MSG + "\"}],")
                .append("\"code\": " + ERROR_CODE + ", \"message\": \"" + ERROR_MSG + "\"}}")
                .toString();
            responseContent.append("HTTP/1.1 " + ERROR_CODE + " Not Found\n")
                .append("Content-Type: application/json; charset=UTF-8\n")
                .append("Content-Length: " + errorContent.length() + "\n\n")
                .append(errorContent + "\n\n")
                .append("--" + RESPONSE_BOUNDARY + "--\n\n");
          } else {
            responseContent.append("--" + RESPONSE_BOUNDARY + "\n")
                .append("Content-Type: application/http\n")
                .append("Content-Transfer-Encoding: binary\n")
                .append("Content-ID: response-1\n\n")
                .append("HTTP/1.1 200 OK\n")
                .append("Content-Type: application/json; charset=UTF-8\n")
                .append("Content-Length: " + content1.length() + "\n\n")
                .append(content1 + "\n\n")
                .append("--" + RESPONSE_BOUNDARY + "\n")
                .append("Content-Type: application/http\n")
                .append("Content-Transfer-Encoding: binary\n")
                .append("Content-ID: response-2\n\n");

            if (testServerError) {
              String errorContent = new StringBuilder().append(
                  "{\"error\": { \"errors\": [{\"domain\": \"" + ERROR_DOMAIN + "\",").append(
                  "\"reason\": \"" + ERROR_REASON + "\", \"message\": \"" + ERROR_MSG + "\"}],")
                  .append("\"code\": " + ERROR_CODE + ", \"message\": \"" + ERROR_MSG + "\"}}")
                  .toString();
              responseContent.append("HTTP/1.1 " + ERROR_CODE + " Not Found\n")
                  .append("Content-Type: application/json; charset=UTF-8\n")
                  .append("Content-Length: " + errorContent.length() + "\n\n")
                  .append(errorContent + "\n\n")
                  .append("--" + RESPONSE_BOUNDARY + "--\n\n");
            } else if (testAuthenticationError) {
              responseContent.append("HTTP/1.1 401 Unauthorized\n")
                  .append("Content-Type: application/json; charset=UTF-8\n\n")
                  .append("--" + RESPONSE_BOUNDARY + "--\n\n");
            } else {
              responseContent.append("HTTP/1.1 200 OK\n")
                  .append("Content-Type: application/json; charset=UTF-8\n")
                  .append("Content-Length: " + content2.length() + "\n\n")
                  .append(content2 + "\n\n")
                  .append("--" + RESPONSE_BOUNDARY + "--\n\n");
            }
          }
          response.setContent(responseContent.toString());
          return response;
        }
      };
    }
  }

  private BatchRequest getBatchPopulatedWithRequests(boolean testServerError,
      boolean testAuthenticationError, boolean returnSuccessAuthenticatedContent)
      throws IOException {
    MockTransport transport = new MockTransport(testServerError, testAuthenticationError);
    JsonHttpClient client = new JsonHttpClient(transport, new JacksonFactory(), BASE_URL);
    JsonHttpRequest jsonHttpRequest1 = new JsonHttpRequest(client, METHOD1, URI_TEMPLATE1, null);
    JsonHttpRequest jsonHttpRequest2 = new JsonHttpRequest(client, METHOD2, URI_TEMPLATE2, null);

    HttpParser parser = new JsonHttpParser(new JacksonFactory());
    BatchRequest batchRequest = new BatchRequest(transport, null).setBatchUrl(
        new GenericUrl(TEST_BATCH_URL));
    HttpRequest request1 = jsonHttpRequest1.buildHttpRequest();
    request1.addParser(parser);
    HttpRequest request2 = jsonHttpRequest2.buildHttpRequest();
    request2.addParser(parser);
    if (testAuthenticationError) {
      request2.setUnsuccessfulResponseHandler(
          new MockUnsuccessfulResponseHandler(transport, returnSuccessAuthenticatedContent));
    }

    batchRequest.queue(request1, MockDataClass1.class, GoogleJsonErrorContainer.class, callback1);
    batchRequest.queue(request2, MockDataClass2.class, GoogleJsonErrorContainer.class, callback2);
    return batchRequest;
  }

  public void testQueueDatastructures() throws Exception {
    BatchRequest batchRequest = getBatchPopulatedWithRequests(false, false, false);
    List<RequestInfo<?, ?>> requestInfos = batchRequest.requestInfos;

    // Assert that the expected objects are queued.
    assertEquals(2, requestInfos.size());
    assertEquals(MockDataClass1.class, requestInfos.get(0).dataClass);
    assertEquals(callback1, requestInfos.get(0).callback);
    assertEquals(MockDataClass2.class, requestInfos.get(1).dataClass);
    assertEquals(callback2, requestInfos.get(1).callback);
    // Assert that the requests in the queue are as expected.
    assertEquals(BASE_URL + URI_TEMPLATE1, requestInfos.get(0).request.getUrl().build());
    assertEquals(BASE_URL + URI_TEMPLATE2, requestInfos.get(1).request.getUrl().build());
    assertEquals(METHOD1, requestInfos.get(0).request.getMethod());
    assertEquals(METHOD2, requestInfos.get(1).request.getMethod());
  }

  public void testBuildMultipartRequest() throws Exception {
    BatchRequest batchRequest = getBatchPopulatedWithRequests(false, false, false);
    HttpRequest multipartRequest = batchRequest.buildHttpRequest();
    assertEquals(HttpMethod.POST, multipartRequest.getMethod());
    assertEquals(TEST_BATCH_URL, multipartRequest.getUrl().build());
    assertEquals(
        "multipart/mixed; boundary=__END_OF_PART__", multipartRequest.getContent().getType());
  }

  public void testExecuteUnparsed() throws Exception {
    BatchRequest batchRequest = getBatchPopulatedWithRequests(false, false, false);
    HttpResponse response = batchRequest.executeUnparsed();
    HttpHeaders responseHeaders = response.getHeaders();
    assertEquals(
        "multipart/mixed; boundary=" + RESPONSE_BOUNDARY, responseHeaders.getContentType());
  }

  public void testExecuteUnparsedWithNothingQueued() throws Exception {
    BatchRequest batchRequest = new BatchRequest(new MockTransport(false, false), null).setBatchUrl(
        new GenericUrl(TEST_BATCH_URL));
    try {
      batchRequest.executeUnparsed();
      fail("Expected " + IllegalStateException.class);
    } catch (IllegalStateException e) {
      // Expected.
    }
  }

  public void testExecute() throws Exception {
    BatchRequest batchRequest = getBatchPopulatedWithRequests(false, false, false);
    batchRequest.execute();
    // Assert callbacks have been invoked.
    assertEquals(1, callback1.successCalls);
    assertEquals(1, callback2.successCalls);
    assertEquals(0, callback2.failureCalls);
    // Assert requestInfos is empty after execute.
    assertTrue(batchRequest.requestInfos.isEmpty());
  }

  public void testExecuteWithError() throws Exception {
    BatchRequest batchRequest = getBatchPopulatedWithRequests(true, false, false);
    batchRequest.execute();
    // Assert callbacks have been invoked.
    assertEquals(1, callback1.successCalls);
    assertEquals(0, callback2.successCalls);
    assertEquals(1, callback2.failureCalls);
    // Assert requestInfos is empty after execute.
    assertTrue(batchRequest.requestInfos.isEmpty());
  }

  public void testExecuteWithVoidCallback() throws Exception {
    subTestExecuteWithVoidCallback(false);
    // Assert callbacks have been invoked.
    assertEquals(1, callback1.successCalls);
    assertEquals(1, callback3.successCalls);
    assertEquals(0, callback3.failureCalls);
  }

  public void testExecuteWithVoidCallbackError() throws Exception {
    subTestExecuteWithVoidCallback(true);
    // Assert callbacks have been invoked.
    assertEquals(1, callback1.successCalls);
    assertEquals(0, callback3.successCalls);
    assertEquals(1, callback3.failureCalls);
  }

  public void subTestExecuteWithVoidCallback(boolean testServerError) throws Exception {
    MockTransport transport = new MockTransport(testServerError, false);
    JsonHttpClient client = new JsonHttpClient(transport, new JacksonFactory(), BASE_URL);
    JsonHttpRequest jsonHttpRequest1 = new JsonHttpRequest(client, METHOD1, URI_TEMPLATE1, null);
    JsonHttpRequest jsonHttpRequest2 = new JsonHttpRequest(client, METHOD2, URI_TEMPLATE2, null);
    HttpParser parser = new JsonHttpParser(new JacksonFactory());
    BatchRequest batchRequest = new BatchRequest(transport, null).setBatchUrl(
        new GenericUrl(TEST_BATCH_URL));
    HttpRequest request1 = jsonHttpRequest1.buildHttpRequest();
    request1.addParser(parser);
    HttpRequest request2 = jsonHttpRequest2.buildHttpRequest();
    request2.addParser(parser);
    batchRequest.queue(request1, MockDataClass1.class, GoogleJsonErrorContainer.class, callback1);
    batchRequest.queue(request2, Void.class, Void.class, callback3);
    batchRequest.execute();
  }

  public void testExecuteWithAuthenticationErrorThenSuccessCallback() throws Exception {
    BatchRequest batchRequest = getBatchPopulatedWithRequests(false, true, true);
    batchRequest.execute();
    // Assert callbacks have been invoked.
    assertEquals(1, callback1.successCalls);
    assertEquals(1, callback2.successCalls);
    assertEquals(0, callback2.failureCalls);
    // Assert requestInfos is empty after execute.
    assertTrue(batchRequest.requestInfos.isEmpty());
  }

  public void testExecuteWithAuthenticationErrorThenErrorCallback() throws Exception {
    BatchRequest batchRequest = getBatchPopulatedWithRequests(false, true, false);
    batchRequest.execute();
    // Assert callbacks have been invoked.
    assertEquals(1, callback1.successCalls);
    assertEquals(0, callback2.successCalls);
    assertEquals(1, callback2.failureCalls);
    // Assert requestInfos is empty after execute.
    assertTrue(batchRequest.requestInfos.isEmpty());
  }
}
