package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * NormalTweet extends Tweet, it's not as important as ImportantTweet
 * @see Tweet
 * @see ImportantTweet
 */
public class NormalTweet extends Tweet implements Tweetable {

    /**
     * This constructor makes a normal tweet with the given message
     * @param message this parameter is the given string for the tweet. If it is set to empty
     *                then it will have the empty string as a message.
     */
    public NormalTweet(String message){
        super(message);
    }

    @Override

    /**
     * isImportant returns false for NormalTweets
     * @return boolean = false
     */
    public Boolean isImportant() {
        return Boolean.FALSE;
    }

    /**
     * The constructor for NormalTweet takes in a message and a date
     * @param message message is the String that NormalTweet has
     * @param date dat eis the Date that NormalTweet has
     */
    public NormalTweet(String message, Date date){
        super(message, date);
    }
}
