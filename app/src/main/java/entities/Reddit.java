package entities;

import org.joda.time.DateTime;


public class Reddit {

    public long created_utc;


    @Override
    public String toString() {
        return "Reddit{" +
                "title='" + title + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", created=" + created +
                '}';
    }

    //Private data members:
    private String title;
    private String thumbnail;
    private DateTime created;

    //Constructors:
    public Reddit(String title, String thumbnail, DateTime created) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.created = created;
    }

    /*
    Getters:
    */
    public String getTitle() {
        return title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public DateTime getCreated() {
        return created;
    }

}
