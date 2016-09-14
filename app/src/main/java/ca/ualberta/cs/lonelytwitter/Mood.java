package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by kieter on 9/13/2016.
 */
public abstract class Mood {
    private Date date;

    // Constructor
    public Mood(Date date) {
        this.date = date;
    }

    public Mood() {
        this.date = new Date();
    }

    // Setter
    public void setDate(Date date) {
        this.date = date;
    }

    // Getter
    public Date getDate() {
        return date;
    }

    public abstract String express();
}
