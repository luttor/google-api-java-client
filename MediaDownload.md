Contents:


# Resumable Media Download #

When you download a large media file from a server, use _resumable media download_ to download the file chunk by chunk. The Google API generated libraries contain convenience methods for interacting with resumable media download, which was introduced in the [1.9.0-beta](http://google-api-java-client.blogspot.com/2012/05/version-190-beta-released.html) version of the Google APIs Client Library for Java.

The resumable media download protocol is similar to the resumable media upload protocol, which is described in the [Google Drive API documentation](https://developers.google.com/drive/web/manage-uploads#resumable).

# Implementation Details #
The main classes of interest are [MediaHttpDownloader](http://javadoc.google-api-java-client.googlecode.com/hg/1.18.0-rc/com/google/api/client/googleapis/media/MediaHttpDownloader.html) and [MediaHttpDownloaderProgressListener](http://javadoc.google-api-java-client.googlecode.com/hg/1.18.0-rc/com/google/api/client/googleapis/media/MediaHttpDownloaderProgressListener.html). Media content is downloaded in chunks, and chunk size is configurable. If a server error is encountered in a request, then the request is retried.

If methods in the service-specific generated libraries support download in the [Discovery document](https://developers.google.com/discovery/v1/using), then a convenient download method is created for these methods that takes in an [OutputStream](http://docs.oracle.com/javase/1.5.0/docs/api/org/omg/CORBA/portable/OutputStream.html). (For more about using media download with the Google APIs Discovery Service, see [Media download](https://developers.google.com/discovery/v1/using#discovery-doc-methods-mediadownload).)

For example:

```
class CustomProgressListener implements MediaHttpDownloaderProgressListener {
  public void progressChanged(MediaHttpDownloader downloader) {
    switch (downloader.getDownloadState()) {
      case MEDIA_IN_PROGRESS:
        System.out.println(downloader.getProgress());
        break;
      case MEDIA_COMPLETE:
        System.out.println("Download is complete!");
    }
  }
}

OutputStream out = new FileOutputStream("/tmp/driveFile.jpg");

Drive.Files.Get request = drive.files().get(fileId);
request.getMediaHttpDownloader().setProgressListener(new CustomProgressListener());
request.executeMediaAndDownloadTo(out);
```

You can also use this feature without service-specific generated libraries. Here is an example:
```
OutputStream out = new FileOutputStream("/tmp/Test.jpg");

MediaHttpDownloader downloader = new MediaHttpDownloader(transport, httpRequestInitializer);
downloader.setProgressListener(new CustomProgressListener());
downloader.download(requestUrl, out);
```

# Direct Media Download #

Resumable media download is enabled by default, but you can disable it and use direct media download instead, for example if you are downloading a small file. Direct media download was introduced in the [1.9.0-beta](http://google-api-java-client.blogspot.com/2012/05/version-190-beta-released.html) version of the Google APIs Client Library for Java.

Direct media download downloads the whole media content in one HTTP request, as opposed to the resumable media download protocol, which can download in multiple requests. Doing a direct download reduces the number of HTTP requests but increases the chance of failures (such as connection failures) that can happen with large downloads.

The usage is the same as what is described above, plus the following call that tells [MediaHttpDownloader](http://javadoc.google-api-java-client.googlecode.com/hg/1.18.0-rc/com/google/api/client/googleapis/media/MediaHttpDownloader.html) to do direct downloads:

```
mediaHttpDownloader.setDirectDownloadEnabled(true);
```