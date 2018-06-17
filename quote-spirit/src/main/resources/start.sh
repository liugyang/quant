#!/bin/sh
echo "starting"
PIDFILE="./run.pid"
pwd=`pwd`
cd ${pwd}
nohup java -jar stock-spirit-0.0.1-SNAPSHOT.jar & echo $! > ${PIDFILE}
echo "start ok"