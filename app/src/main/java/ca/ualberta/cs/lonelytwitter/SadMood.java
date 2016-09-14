package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by kieter on 9/13/2016.
 */
public class SadMood extends Mood{

    public SadMood(Date date) {
        super(date);
    }

    public SadMood() {
    }

    public String express() {
        return "=(";
    }
}
