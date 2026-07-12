package exercises;

public class FileService {

    private MyFileReader reader;
    private MyFileWriter writer;

    public FileService(MyFileReader reader, MyFileWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public String processFile() {

        String content = reader.read();

        writer.write(content);

        return "Processed " + content;

    }

}