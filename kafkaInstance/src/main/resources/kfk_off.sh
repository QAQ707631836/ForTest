#! /bin/bash



sh /root/kafka_2.12-3.1.0/bin/kafka-server-stop.sh

sleep 3s

sh /root/kafka_2.12-3.1.0/bin/zookeeper-server-stop.sh
