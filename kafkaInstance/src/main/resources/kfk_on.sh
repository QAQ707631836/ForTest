#! /bin/bash

sh /root/kafka_2.12-3.1.0/bin/zookeeper-server-start.sh -daemon /root/kafka_2.12-3.1.0/config/zookeeper.properties

sleep 3s

sh /root/kafka_2.12-3.1.0/bin/kafka-server-start.sh -daemon /root/kafka_2.12-3.1.0/config/server.properties
