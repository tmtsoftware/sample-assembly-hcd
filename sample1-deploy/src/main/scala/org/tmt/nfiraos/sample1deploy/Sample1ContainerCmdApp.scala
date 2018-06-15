package org.tmt.nfiraos.sample1deploy

import csw.framework.deploy.containercmd.ContainerCmd

object Sample1ContainerCmdApp extends App {

  ContainerCmd.start("sample1-container-cmd-app", args)

}
