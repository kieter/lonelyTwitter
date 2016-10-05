package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * TweetList is a list of tweets
 *
 * @since 1.0
 * @see Tweet
 */
class TweetList{

    /**
     * tweets Contains Tweets
     */
    ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * hasTweet returns a boolean, whether or not the TweetList contains a certain tweet
     * @param tweet The tweet to check containment for
     * @return boolean
     */
    public boolean hasTweet (Tweet tweet){
        return tweets.contains(tweet);
    }

    /**
     * addTweet adds a tweet to the TweetList
     * @param tweet The tweet to be added
     */
    public void add(Tweet tweet) {
        if (this.tweets.contains(tweet)) {
            throw new IllegalArgumentException();
        } else {
            tweets.add(tweet);
        }
    }

    /**
     * getTweet returns a Tweet given an index
     * @param i The index of the Tweet to be returned.
     * @return Tweet
     */
    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    /**
     * Anonymous class, it compares two tweets.
     */
    class TweetComparator implements Comparator<Tweet> {
        /**
         * Anonymous class function, it compares two tweets, using compareTo
         * Tweets that have a date before another tweet take precedence
         * @param tweet1 first tweet
         * @param tweet2 second tweet
         * @return Integer
         */
        public int compare(Tweet tweet1, Tweet tweet2) {
            return tweet2.getDate().compareTo(tweet1.getDate());
        }
    }

    /**
     * getTweets returns a Collection of tweets, sorted based on date (first created first)
     * @return List<Tweet>
     */
    public List<Tweet> getTweets() {
        Collections.sort(this.tweets, new TweetComparator());
        return this.tweets;
    }

    /**
     * delete removes a tweet from the tweetList otherwise does nothing
     * @param a the Tweet to be deleted
     */
    public void delete(Tweet a) {
        tweets.remove(a);
    }

    /**
     * removeTweet removes a given tweet from the tweetList otherwise does nothing
     * @param a the Tweet to be deleted
     */
    public void removeTweet(Tweet a) {
        tweets.remove(a);
    }

    /**
     * getCount returns a integer of the size of the tweetList
     * @return Integer
     */
    public int getCount() {
        return tweets.size();
    }
}
