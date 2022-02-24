#! /bin/bash

sh /root/kafka_2.12-3.1.0/bin/kafka-console-producer.sh --bootstrap-server localhost:9092 --topic $1
