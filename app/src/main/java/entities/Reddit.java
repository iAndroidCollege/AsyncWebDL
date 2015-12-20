package entities;

import org.joda.time.DateTime;


public class Reddit {
    //Private data members:
    public String title;
    public String thumbnail;
    public Integer created_utc;

  // public DateTime created;

    public Reddit(){

    }



    @Override
    public String toString() {
        return "Reddit{" +
                "title='" + title + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", created=" + created_utc +
                '}';
    }



    //Constructors:
    public Reddit(String title, String thumbnail, DateTime created) {
        this.title = title;
        this.thumbnail = thumbnail;
       // this.created = created;
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

    //public DateTime getCreated() {
        //return created;
    //}

}
