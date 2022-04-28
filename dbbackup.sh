#!/bin/bash 
# First configure AWS key , or this will fail.

DBDOCKER=`docker ps | grep postgres | cut -d " " -f 1`
TSTAMP=`date +%A"_"%H`
docker exec -t $DBDOCKER pg_dumpall -c -U postgres > dump_$TSTAMP.sql
aws s3 cp dump_$TSTAMP.sql s3://pos-db-backup/

