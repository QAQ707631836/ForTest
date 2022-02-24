package filesink;

public class Record {
    String content;
    String id;
    Record(String c){
        this.content = c;
    }

    public String getId() {
        return content.split("/")[0];
    }
}
