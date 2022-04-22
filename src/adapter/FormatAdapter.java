package adapter;

interface XML{
    void read(FileType audioType, String filename);
}

interface JSON{
    void readJSON(String filename);
}

class JSONReader implements JSON{
    @Override
    public void readJSON(String filename) {
        System.out.println("Reading json file: " + filename);
    }
}
enum FileType {
    XML,
    JSON,
}
class FileConverter implements XML{
    JSON json;
    public FileConverter(FileType fileType){
        if (FileType.JSON == fileType){
            this.json = new JSONReader();
        }
    }
    @Override
    public void read(FileType audioType, String filename) {
        if(audioType == FileType.JSON){
            json.readJSON(filename);
        }

    }

}
class DefaultXMLReader implements XML{
    FileConverter file;

    @Override
    public void read(FileType fileType, String filename) {
        if(FileType.XML == fileType){
            // default
            System.out.println("Reading xml file: "  + filename);
        }
        else if(fileType.equals(FileType.JSON)){
            file = new FileConverter(fileType);
            file.read(fileType, filename);
        }
        else {
            System.out.println("Invalid type of file. " + fileType + " formatNotSupported");
        }
    }
}
class RUNNER{
    public static void main(String[] args) {
        DefaultXMLReader audioPlayer = new DefaultXMLReader();
        audioPlayer.read(FileType.JSON, "beyond the horizon.json");
        audioPlayer.read(FileType.XML, "alone.xml");
        audioPlayer.read(FileType.XML, "far far away.xml");
        audioPlayer.read(FileType.JSON, "mind me.json");
    }
}