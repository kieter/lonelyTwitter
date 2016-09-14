package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by kiete on 9/13/2016.
 */
public class HappyMood extends Mood {

    public HappyMood(Date date) {
        super(date);
    }

    public HappyMood() {
    }

    public String express() {
        return "=)";
    }
}
