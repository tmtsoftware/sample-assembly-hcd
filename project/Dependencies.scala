import sbt._

object Dependencies {

  val Sample1Assembly = Seq(
    CSW.`csw-framework`,
    CSW.`csw-command-client`,
    CSW.`csw-location-client`,
    CSW.`csw-logging`,
    Libs.`scalatest` % Test,
    Libs.`junit` % Test,
    Libs.`junit-interface` % Test
  )

  val Sample1Hcd = Seq(
    CSW.`csw-framework`,
    CSW.`csw-command-client`,
    CSW.`csw-location-client`,
    CSW.`csw-logging`,
    Libs.`scalatest` % Test,
    Libs.`junit` % Test,
    Libs.`junit-interface` % Test
  )

  val Sample1Deploy = Seq(
    CSW.`csw-framework`
  )
}
