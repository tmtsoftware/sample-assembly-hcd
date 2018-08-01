# sample

This project implements an HCD (Hardware Control Daemon) and Assembly using 
TMT Common Software ([CSW](https://github.com/tmtsoftware/csw-prod)) APIs. 

## Subprojects

* sample1-assembly - an assembly that talks to the sample HCD
* sample1-hcd - an HCD that talks to the sample hardware
* sample1-deploy - for starting/deploying HCD's and Assembly's

## Build Instructions

The build is based on sbt and depends on libraries published to bintray from the 
[csw-prod](https://github.com/tmtsoftware/csw-prod) project.

See [here](https://www.scala-sbt.org/1.0/docs/Setup.html) for instructions on installing sbt.


## Pre-requisites before running Components

run csw-services.sh script
    - Clone csw-prod
    - Run sbt universal:stage
    - ```$cd target/universal/stage/bin```
    - ```$./csw-services.sh start -i en0```

Necessary environment variables  - 
Export clusterSeeds=ip:5552 - Use your own ip

## Running HCD and Assembly

### Stage and run
   ```sbtshell
    sbt universal:stage
```
 ```bash
 cd sample1-deploy/target/universal/stage/bin
 ./sample-1-container-cmd-app --standalone --local /Users/poorvagokhale/TMT/spikes/sample1/sample1-deploy/src/main/resources/Sample1AssemblyStandalone.conf
 ```

 
