package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This is an abstract class of Tweet. It's real implementations are NormalTweet and
 * ImportantTweet.
 *
 * @since 1.0
 * @see NormalTweet
 * @see ImportantTweet
 */
public abstract class Tweet {

    /**
     * Message is a String and contains the Tweet's message
     */
    private String message;

    /**
     * date is a Date and contains the Tweet's date
     */
    private Date date;

    /**
     * Constructor given a message
     * @param message message is the String that Tweet has.
     */
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    /**
     * Constructor given a message and date
     * @param message message is the String that has
     * @param date date is the Date that the string has
     */
    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }


    /**
     * isImportant returns a boolean whether or not the Tweet is important
     * @return boolean
     */
    public abstract Boolean isImportant();

    /**
     * setMessage changes the message of the tweet, it throws TweetTooLongException if the
     * tweet is longer than 140 characters.
     * @param message message is the String that the tweet will be set to
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            //Do something
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * setDate changes the date of the tweet
     * @param date date is the new Date given to the tweet
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * getMessage returns the message
     * @return String
     */
    public String getMessage() {
        return message;
    }

    /**
     * getDate returns the tweet's Date
     * @return Date
     */
    public Date getDate() {
        return date;
    }

    @Override
    /**
     * toString is overrided and returns "date" | "message"
     * @reutrn String
     */
    public String toString(){
        return  date.toString() + " | " + message;
    }
}
