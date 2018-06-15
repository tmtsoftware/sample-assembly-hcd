# sample1-deploy

This module contains apps and configuration files for host deployment using 
HostConfig (https://tmtsoftware.github.io/csw-prod/apps/hostconfig.html) and 
ContainerCmd (https://tmtsoftware.github.io/csw-prod/framework/deploying-components.html).

An important part of making this work is ensuring the host config app (Sample1HostConfigApp) is built
with all of the necessary dependencies of the components it may run.  This is done by adding settings to the
built.sbt file:

```
lazy val `sample1-deploy` = project
  .dependsOn(
    `sample1-assembly`,
    `sample1-hcd`
  )
  .enablePlugins(JavaAppPackaging)
  .settings(
    libraryDependencies ++= Dependencies.Sample1Deploy
  )
```

and in Libs.scala:

```

  val `csw-framework`  = "org.tmt" %% "csw-framework"  % Version

```

To start sample1 Assembly and HCD, follow below steps:

 - Run `sbt sample1-deploy/universal:packageBin`, this will create self contained zip in target/universal directory
 - Unzip generate zip and enter into bin directory
 - Run container cmd script or host config app script
 - Ex.  `./sample1-host-config-app --local ../../../../sample1-deploy/src/main/resources/Sample1HostConfig.conf -s ./sample1-container-cmd-app`

Note: the CSW Location Service cluster seed must be running, and appropriate environment variables set to run apps.
See https://tmtsoftware.github.io/csw-prod/apps/cswclusterseed.html .