package com.polytech.si3.mypolytech.html.video;

/**
 * Created by Gunther on 4/4/2016.
 */
public class Video {

    private final String title, description, videoId, thumbnail;

    public Video(String title, String description, String videoId, String thumbnail) {
        this.title = title;
        this.description = description;
        this.videoId = videoId;
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Video{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", videoId='" + videoId + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getVideoId() {
        return videoId;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
