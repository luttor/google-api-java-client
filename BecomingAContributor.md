Contents:



# Contributor License Agreements (CLA) #

Before we can accept your code patches, you need to submit either an individual or a corporate Contributor License Agreement (CLA):

  * If you are an individual writing original source code and you're certain that you own the intellectual property, submit an [individual CLA](https://developers.google.com/open-source/cla/individual).
  * If you work for a company, your company must submit a [corporate CLA](https://developers.google.com/open-source/cla/corporate) to indicate that you are allowed to contribute your work to this client library.

Follow either of the two links above to access the appropriate CLA and instructions for how to sign and return it. Once we receive it, we can add you to the official list of contributors.

# Overview of Submitting Patches #

To contribute code to this project, follow these general steps:

  1. Sign a Contributor License Agreement, as described above.
  1. Join our [discussion group](http://groups.google.com/group/google-api-java-client).
  1. Set up your [development environment](BecomingAContributor#Setting_up_the_Development_Environment.md).
  1. Associate each of your changesets with an Issue (a bug report or feature request) in this project's [Issue Tracker](http://code.google.com/p/google-api-java-client/issues/list). Create a new Issue if there isn't one already, change its status to "Started," and assign it to yourself.
  1. Check out code, create a new issue on [codereview.appspot.com](http://codereview.appspot.com), and complete the code review process. Detailed instructions for all these processes are given below.
  1. After your code is reviewed and you receive approval, commit the code. If you are not an official Contributor, a Contributor pulls your changeset into the official repository.

We use the following tools and processes:
  * We use the [Mercurial](http://mercurial.selenic.com/) version control system, which is a "distributed" VCS. If you are not familiar with it, we recommend the tutorial by Joel Spolsky at [hginit.com](http://hginit.com/).
  * We use [Maven](http://maven.apache.org/) for the build system, as well as a binary distribution system.
  * We use [codereview.appspot.com](http://codereview.appspot.com) for code reviews. (But note that in the codereview.appspot.com tool, the term "issue" means a code-review request, while in the Issue Tracker, an "issue" is a feature request or bug report.)

If you are an Eclipse developer, use the project-specific code formatting specified in the .settings directory that is automatically processed by Eclipse.


# Setting up the Development Environment #

## Prerequisites ##
  1. Install [Java 6](http://java.com). You might need to set your `JAVA_HOME` variable.
  1. Install [Mercurial (Hg)](http://mercurial.selenic.com/), minimum version 1.6. An optional tutorial is located at [hginit.com](http://hginit.com).
  1. Install [Maven](http://maven.apache.org/download.html). (This document assumes you have basic familiarity with Maven commands.)
  1. Optional: Install the [Android SDK](http://developer.android.com/sdk/index.html) and set your ANDROID\_HOME variable to the install location for Android.
  1. Install [Git](http://git-scm.com/).

**Set up the Mercurial hgrc file:**

To be able to check out and make changes to the code, you need to authenticate with the Hg repository.

Add the following in the `[auth]` section of your ~/.hgrc file with your username and password from https://code.google.com/hosting/settings, as follows:

```
[auth]
google-api-java-client.prefix = https://code.google.com/p/google-api-java-client/
google-api-java-client.username = your_username
google-api-java-client.password = your_password
samples-google-api-java-client.prefix = https://code.google.com/p/google-api-java-client.samples/
samples-google-api-java-client.username = your_username
samples-google-api-java-client.password = your_password
```
## Checking out the code ##
We use two Mercurial repositories:
  * The "default" repository has the library.  The "default" branch has the latest unreleased code under development.  Additionally, each release has its own branch, e.g. "1.6" branch for the 1.6.X-beta releases.
  * The "samples" repository has all of the samples under the "default" branch.
To check out the default library repository in the development "default" branch, run the following command:

```
hg clone https://code.google.com/p/google-api-java-client/ google-api-java-client/default
```

To switch to an alternative branch (for example 1.12):

```
hg update 1.12
```

To switch back to the development branch:

```
hg update default
```

To pull in the latest changes from the central server and update your local workspace to the latest changeset:

```
hg pull --update
```

To check out the "samples" repository:

```
cd <rootDirectory>
hg clone https://code.google.com/p/google-api-java-client.samples/ google-api-java-client/samples 
```

## Maven ##

**Install Google Play Services**

The first time you set up the project, you need to install the google-play-services.jar file. To do this:
  1. Launch Eclipse and select **Window > Android SDK Manager**, or run `android` at the command line.
  1. Scroll to the bottom of the package list and select **Extras > Google Play services**.

```
mvn install:install-file \
           -Dfile=$ANDROID_HOME/extras/google/google_play_services/libproject/google-play-services_lib/libs/google-play-services.jar \
           -DgroupId=com.google.android.google-play-services \
           -DartifactId=google-play-services \
           -Dversion=1 \
           -Dpackaging=jar
```

**Compile the project**

To clean, compile, test, and install the project, run the following command:

```
mvn clean install
```

Maven installs the compiled binaries to a local repository (for example ~/.m2/repository). It searches for binaries in that repository before fetching from the [Maven central repository](http://search.maven.org/#search%7Cga%7C1%7C).

**Note:**
This library depends on [google-http-java-client](https://code.google.com/p/google-http-java-client/) and [google-oauth-java-client](https://code.google.com/p/google-oauth-java-client/). When working on a new version of all three libraries that are not yet released to Maven central, you must compile them in the following order:
  1. google-http-java-client
  1. google-oauth-java-client
  1. google-api-java-client
Compiling in this order ensures that Maven picks up the compiled binaries for dependent library compilation.

## Eclipse ##
**Import to Eclipse:**

The project is designed to work well with Eclipse. To convert the Maven project to an Eclipse project (that is, to create `.classpath`, `project.property` and so on), run the following command:

```
mvn eclipse:eclipse
```
To import the project to an Eclipse workspace:
  1. From within Eclipse, select **File > Import...**.
  1. Select **General > Existing Project into Workspace** and click **Next**.
  1. Next to **Select root directory**, browse to the directory where your project is synced (for example google-api-java-client/default) and click **OK**.
  1. Click **Next** and **Finish**.

**Add the `M2_REPO` classpath variable to Eclipse:**

When you run `mvn eclipse:eclipse`,  Maven creates the entire dependency classpath by using the `M2_REPO` variable, which is not defined in Eclipse by default. To add the `M2_REPO` classpath variable into the Eclipse IDE, follow these instructions:

  1. From within Eclipse, select **Window > Preferences** (or on Mac, **Eclipse > Preferences...**).
  1. Select **Java > Build Path > Classpath Variables**.
  1. Click **New...**.
  1. Type `M2_REPO` as the name, and choose the local Maven repository, for example ~/.m2/repository.
  1. Click **OK**. Eclipse reminds you to rebuild all projects to work with the new classpath variable.
  1. Click **Done**.

You only need to add `M2_REPO` once, and it is shared among all of your Eclipse workspaces.

# Code Review Process #

## Downloading the upload.py script ##

Download the [upload.py](http://codereview.appspot.com/static/upload.py) script and optionally add it to your PATH.

The first time you run `upload.py`, it asks you for an [application-specific password](http://support.google.com/accounts/bin/answer.py?hl=en&answer=185833):

```
Email (login for uploading to codereview.appspot.com): your_email_address@yourdomain.com
Password for your_email_address@yourdomain.com: <enter your application-specific password>
```

## Preparing your code for review ##

Before you send the code for review, you must run Clirr to catch backwards compatibility problems in your code. If any errors are reported, you need to either fix them or update the clirr-ignored-differences.xml file.

```
mvn -q clirr:check
```

You must also run the FindBugs tool to catch bugs in the code. If any errors are reported, you need to either fix them or update the findbugs-exclude.xml file. (Note that FindBugs is very slow.)

```
mvn findbugs:check
```

## Starting the code review ##

When ready for review, create a new issue on codereview.appspot.com:
```
upload.py --base_url=https://code.google.com/p/google-api-java-client/ --send_mail -r reviewer@somedomain --cc ...
```

After making more changes, upload a new patch, for example to issue number 123456:
```
upload.py -i 123456
```

For more options, run `upload.py --help`.

The process is similar for samples:

```
upload.py --base_url=https://code.google.com/p/google-api-java-client.samples/ --send_mail -r reviewer@somedomain --cc ...
upload.py -i 123456
```

## Code reviewer ##

If you are a code reviewer, import and test changesets before you approve them, then remove the changes from your local workspace after you're done.

**Get set up**

Download the [hg\_import.py](http://google-http-java-client.googlecode.com/hg/hg_import.py) script and make an alias for easy use:
```
alias hg_import.py='<rootDirectory>/hg_import.py'
```

**Import a changeset**

To import a patch into your hg clone:
  1. Open the issue within codereview.appspot.com.
  1. For the patch in question, look for "Download raw" at the top right of the patch specification.
  1. Click "raw" to get a URL for the file to import.

Now import the file. For example:
```
hg_import.py http://codereview.appspot.com/download/issue123456_10000.diff
```

**Test the changeset**

To run the tests and install, use the following command:

```
mvn clean install checkstyle:check
```

**Unpatch a changeset**

When finishing a code review, use the following command to get rid of an imported patch. **Be careful**: It literally erases all of your local changes.
```
hg revert -a && hg purge
```

**Approve a changeset on codereview.appspot.com**

In general, code cannot be committed into the Hg server until the code reviewer is satisfied that the code is ready.  At that point, the convention is to reply with the message "LGTM" (Looks Good To Me).

## Committing the code ##

**Important:** Before you commit your code, pull the latest changes into your local workspace and update your local workspace to the latest changeset:

```
hg pull --update
```

(If the central Mercurial server has changes that you have not yet pulled into your local workspace, committing your code creates a new branch or "head," because the "parent changeset" for your commit is the latest changeset in the server. The only way to resolve this is to merge the heads. To avoid this complexity, run `hg pull --update` as shown above.)

To commit the code **locally**:
```
hg commit
```

Enter a message such as the following (assuming you are fixing or implementing Issue # 123, as listed in this project's [Issue Tracker](https://code.google.com/p/google-api-java-client/issues/list)):

```
api Issue 123: NullPointerException when passing null to processFoo()

http://codereview.appspot.com/123456/
```

Before the first colon and the description:

  * Include the project, which is `api`, `http`, or `oauth`.
  * If this is a fix to a problem on http://code.google.com/p/google-api-java-client/issues, include the Issue number, as shown.
  * If this is a change for a particular branch, include the branch number.

Following the description, always include a link to the issue on the codereview site. This link is important because without it, there's no convenient way to figure out the code review associated with a commit, which is useful for maintaining a history of the discussion.

To push the change to the server:

```
hg push
```

If it asks for your password, use the password from https://code.google.com/hosting/settings.

If during `hg push` you get an error message about creating a new head (perhaps you forgot to run `hg pull --update`), here's how to merge with the latest changes:
```
hg pull
hg merge
hg commit
hg push
```

If you get an HTTP `403 Forbidden` status code, you are not on the list at https://code.google.com/p/google-api-java-client/people/list .  Ask one of the Owners to add you to the list as a Committer.

## Closing the issue ##

Make sure to close the issue in the code-review tool. To do this:
  1. Select the issue in [codereview.appspot.com](http://codereview.appspot.com).
  1. Click the "X" that is at the top-left, preceding "Id."