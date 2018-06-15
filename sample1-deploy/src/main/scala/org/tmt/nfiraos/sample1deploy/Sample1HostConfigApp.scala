package org.tmt.nfiraos.sample1deploy

import csw.framework.deploy.hostconfig.HostConfig

object Sample1HostConfigApp extends App {

  HostConfig.start("sample1-host-config-app", args)

}
