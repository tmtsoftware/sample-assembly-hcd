lazy val `sample1-assembly` = project
  .settings(
    libraryDependencies ++= Dependencies.Sample1Assembly
  )

lazy val `sample1-hcd` = project
  .settings(
    libraryDependencies ++= Dependencies.Sample1Hcd
  )

lazy val `sample1-deploy` = project
  .dependsOn(
    `sample1-assembly`,
    `sample1-hcd`
  )
  .enablePlugins(JavaAppPackaging, CswBuildInfo)
  .settings(
    libraryDependencies ++= Dependencies.Sample1Deploy
  )
