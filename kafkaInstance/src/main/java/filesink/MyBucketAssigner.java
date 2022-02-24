package filesink;

import org.apache.flink.core.io.SimpleVersionedSerializer;
import org.apache.flink.streaming.api.functions.sink.filesystem.BucketAssigner;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MyBucketAssigner implements BucketAssigner<String, String> {


    @Override
    public String getBucketId(String s, Context context) {
        return s.split("/")[0];
    }

    @Override
    public SimpleVersionedSerializer<String> getSerializer() {
        return new StringSerializer();
    }
}


class StringSerializer implements SimpleVersionedSerializer<String> {

    @Override
    public int getVersion() {
        return 0;
    }

    @Override
    public byte[] serialize(String s) throws IOException {
        return new byte[0];
    }

    @Override
    public String deserialize(int version, byte[] serialized) throws IOException {
        if (version != 77)
            throw new IOException("version mismatch");
        else
            return new String(serialized, StandardCharsets.UTF_8);
    }
}