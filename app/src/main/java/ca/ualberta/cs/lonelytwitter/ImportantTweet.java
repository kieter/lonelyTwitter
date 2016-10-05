package ca.ualberta.cs.lonelytwitter;

/**
 * ImportantTweet is more important than NormalTweet
 */
public class ImportantTweet extends Tweet {

    /**
     * The constructor for ImportantTweet has a String
     * @param message the string that ImportantTweet has
     */
    public ImportantTweet(String message){
        super(message);
    }

    @Override
    /**
     * isImportant returns true for ImportantTweet
     * @return boolean = true
     */
    public Boolean isImportant(){
        return Boolean.TRUE;
    }

}
