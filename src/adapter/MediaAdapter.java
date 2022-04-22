package adapter;

interface MediaPlayer{
    void play(AudioType audioType, String filename);
}

interface AdvancedMediaPlayer{
    void playVlc(String filename);
    void playMp4(String filename);
}

class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String filename) {
        System.out.println("Playing vlc file: " + filename);
    }

    @Override
    public void playMp4(String filename) {

    }
}
class Mp4Player implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String filename) {

    }

    @Override
    public void playMp4(String filename) {
        System.out.println("Playing mp4 file: " + filename);
    }
}
enum AudioType {
    VLC,
    MP4,
    MP3,
    AVI
}
public class MediaAdapter implements MediaPlayer{
    AdvancedMediaPlayer advancedMediaPlayer;
    public MediaAdapter(AudioType audioType){
        if (AudioType.VLC == audioType){
            this.advancedMediaPlayer = new VlcPlayer();
        }
        else if(AudioType.MP4 == audioType){
            this.advancedMediaPlayer = new Mp4Player();
        }
    }
    @Override
    public void play(AudioType audioType, String filename) {
        if(audioType == AudioType.VLC){
            advancedMediaPlayer.playVlc(filename);
        }
        else if (audioType == AudioType.MP4){
            advancedMediaPlayer.playMp4(filename);
        }
    }

}
class AudioPlayer implements MediaPlayer{
    MediaAdapter mediaAdapter;

    @Override
    public void play(AudioType audioType, String filename) {
        if(AudioType.MP3 == audioType){
            System.out.println("Playing mp3 file: "  + filename);
        }
        else if(audioType.equals(AudioType.MP4) || audioType.equals(AudioType.VLC)){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, filename);
        }
        else {
            System.out.println("Invalid media. " + audioType + " formatNotSupported");
        }
    }
}
class Demo{
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play(AudioType.MP3, "beyond the horizon.mp3");
        audioPlayer.play(AudioType.MP4, "alone.mp4");
        audioPlayer.play(AudioType.VLC, "far far away.vlc");
        audioPlayer.play(AudioType.AVI, "mind me.avi");
    }
}