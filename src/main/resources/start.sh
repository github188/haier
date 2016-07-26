#!/bin/sh
base_dir=$(dirname $0)/..

# loading dependency jar in lib directory
for file in $base_dir/lib/*.jar;
do
  JARS=$JARS,$file
done
  JARS=${JARS:1}

if [ -z "$PUBLISH_DATASOURCE_OPTS" ]; then
  PUBLISH_DATASOURCE_OPTS="-Dpublish-datasource=$base_dir/conf/datasource.properties"
fi

if [ -z "$PUBLISH_ORACLE_OPTS" ]; then
  PUBLISH_ORACLE_OPTS="-Dpublish-oracle=$base_dir/conf/oracle.properties"
fi

if [ -z "$PUBLISH_CORESITE_OPTS" ]; then
  PUBLISH_CORESITE_OPTS="-Dpublish-coresite=$base_dir/conf/core-site.xml"
fi

if [ -z "$PUBLISH_HDFSSITE_OPTS" ]; then
  PUBLISH_HDFSSITE_OPTS="-Dpublish-hdfssite=$base_dir/conf/hdfs-site.xml"
fi

if [ -z "$PUBLISH_HBASESITE_OPTS" ]; then
  PUBLISH_HBASESITE_OPTS="-Dpublish-hbasesite=$base_dir/conf/hbase-site.xml"
fi

master=spark://host225:7077
jar=$base_dir/lib/offline-bayrange-1.0-SNAPSHOT.jar
main_class=offline.BayRange
cores=10
memory=10g


cmd="spark-submit\
 --master ${master}\
 --class ${main_class}\
 --total-executor-cores ${cores}\
 --executor-memory ${memory}\
 --jars ${JARS}\
 --driver-java-options \"$PUBLISH_DATASOURCE_OPTS $PUBLISH_ORACLE_OPTS $PUBLISH_CORESITE_OPTS $PUBLISH_HDFSSITE_OPTS $PUBLISH_HBASESITE_OPTS\"\
 $jar"

$base_dir/bin/daemon.sh start "$cmd"
