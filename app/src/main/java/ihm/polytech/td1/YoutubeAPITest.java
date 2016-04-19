package ihm.polytech.td1;

import java.util.List;

import ihm.polytech.td1.Video;
import ihm.polytech.td1.YoutubeAPI;


/**
 * Created by Gunther on 4/4/2016.
 */
public class YoutubeAPITest {

    public void testReadVideos() {
        YoutubeAPI api = new YoutubeAPI("UUC0wTzkzyLDrJt1NjeIT3Yg");
        List<Video> videos = api.getVideos();
        assert !videos.isEmpty() : "Videos should not be empty";
        for(Video v : videos) {
            System.out.println(v);
        }
    }

    public static void main(String ... args) {
        new YoutubeAPITest().testReadVideos();
    }
}