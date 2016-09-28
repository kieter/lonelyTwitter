package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by kiete on 9/27/2016.
 */
class TweetList{
    ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public boolean hasTweet (Tweet tweet){
        return tweets.contains(tweet);
    }

    public void add(Tweet tweet) {
        if (this.tweets.contains(tweet)) {
            throw new IllegalArgumentException();
        } else {
            tweets.add(tweet);
        }
    }

    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    class TweetComparator implements Comparator<Tweet> {
        public int compare(Tweet tweet1, Tweet tweet2) {
            return tweet2.getDate().compareTo(tweet1.getDate());
        }
    }

    public List<Tweet> getTweets() {
        Collections.sort(this.tweets, new TweetComparator());
        return this.tweets;
    }

    public void delete(Tweet a) {
        tweets.remove(a);
    }

    public void removeTweet(Tweet a) {
        tweets.remove(a);
    }


    public int getCount() {
        return tweets.size();
    }
}
