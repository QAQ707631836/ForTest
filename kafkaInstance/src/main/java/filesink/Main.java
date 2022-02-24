package filesink;


import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.restartstrategy.RestartStrategies;
import org.apache.flink.api.common.serialization.SimpleStringEncoder;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.connector.file.sink.FileSink;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.core.fs.Path;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.filesystem.rollingpolicies.DefaultRollingPolicy;

import java.util.concurrent.TimeUnit;

/**
 * 搭建单机版本的kafka
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // 1.创建执行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(1000L);
        env.setParallelism(1);

        KafkaSource<String> source = KafkaSource.<String>builder()
                .setBootstrapServers("192.168.84.129:9092")
                .setTopics("test")
                .setGroupId("my-group")
                .setStartingOffsets(OffsetsInitializer.latest())
                .setValueOnlyDeserializer(new SimpleStringSchema())
                .build();

        KafkaSource.builder().

                DataStreamSource < String > kafkaSource = env.fromSource(source, WatermarkStrategy.noWatermarks(), "Kafka Source");

        kafkaSource.print();


        FileSink<String> sink = FileSink
                .forRowFormat(new Path("C:\\Users\\wb.wangzhihao04\\Desktop\\dir"),
                        new SimpleStringEncoder<String>("UTF-8"))
                .withBucketAssigner(new MyBucketAssigner())
                .withRollingPolicy(
                        DefaultRollingPolicy.builder()
                                .withRolloverInterval(TimeUnit.SECONDS.toMillis(5))
                                .withInactivityInterval(TimeUnit.SECONDS.toMillis(2))
                                .withMaxPartSize(1024 * 1024)
                                .build())
                /**
                 * 一：达到5s
                 * 二：未接受消息持续2s
                 * 三：文件达到1M
                 */
                .build();
        kafkaSource.sinkTo(sink);
        env.execute();
    }
}
