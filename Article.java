package news;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by eric on 22/03/2016.
 */
public class Article implements Parcelable {

    private int id;
    private String title;
    private String content;
    private String author;
    private String date;
    private int category;
    private int mediaType;
    private String mediaPath;

    public Article(int id, String title, String content, String date, String author, int category, int mediaType, String mediaPath) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.author = author;
        this.category = category;
        this.mediaType = mediaType;
        this.mediaPath = mediaPath;

    }

    protected Article(Parcel in) {
        id = in.readInt();
        title = in.readString();
        content = in.readString();
        author = in.readString();
        date = in.readString();
        category = in.readInt();
        mediaType = in.readInt();
        mediaPath = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(content);
        dest.writeString(author);
        dest.writeString(date);
        dest.writeInt(category);
        dest.writeInt(mediaType);
        dest.writeString(mediaPath);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Article> CREATOR = new Parcelable.Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public int getNumberCategory() {
        return category;
    }

    public String getCategory() {
        if (getNumberCategory() == 1)
            return "Politique";
        else
            return "Société";
    }

    public int getMediaType() {
        return mediaType;
    }

    public String getMediaPath() {
        return mediaPath;
    }


    public String getMediaImage(){
        if (!mediaPath.contains("www.youtube.com")){
            return mediaPath;
        }
        String imageLink = mediaPath.replace("https://www.youtube.com/watch?v=", "");
        return "http://img.youtube.com/vi/"+imageLink+"/0.jpg";
    }
}