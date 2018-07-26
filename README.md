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

Make sure that the necessary environment variables are set. For example:

* Set the environment variables (Replace IP address and port with your own values):
```bash
export clusterSeeds=192.168.178.77:7777
```
for bash shell, or 
```csh
setenv clusterSeeds 192.168.178.77:7777
```

run cluster-seed
    - Clone csw-prod
```bash
git checkout d392316b7
sbt universal:stage
sbt universal:publishLocal
cd target/universal/stage/bin
./csw-cluster-seed --clusterPort=3552
```

## Running HCD and Assembly

### Stage and run
   ```sbtshell
    sbt universal:stage
```
 ```bash
 cd sample1-deploy/target/universal/stage/bin
 ./sample-1-container-cmd-app --standalone --local /Users/poorvagokhale/TMT/spikes/sample1/sample1-deploy/src/main/resources/Sample1AssemblyStandalone.conf
 ```

 
