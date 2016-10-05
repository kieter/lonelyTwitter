package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * TweetListTest tests the methods of TweetList
 * @see TweetList
 */
public class TweetListLTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
    public TweetListLTest() {
        super(LonelyTwitterActivity.class);
    }

    /**
     * testAddTweet tests adding a tweet
     */
    public void testAddTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("Hello!!!");
        Tweet same_tweet = new NormalTweet("Hello!!!");

        list.add(same_tweet);
        try {
            list.add(tweet);
        } catch (IllegalArgumentException duplicateError) {
            assertTrue(true);
        }

        assertTrue(list.hasTweet(tweet));
    }

    /**
     * testHasTweet tests hasTweet
     */
    public void testHasTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("Hello!!!");

        assertFalse(list.hasTweet(tweet));
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    /**
     * testGetTweet tests getTweet
     */
    public void testGetTweet() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello!");
        Tweet b = new NormalTweet("Hi");

        list.add(a);
        list.add(b);

        assertEquals(a, list.getTweet(0));
        assertEquals(b, list.getTweet(1));
    }

    /**
     * testDeleteTweet tests deleteTweet
     */
    public void testDeleteTweet() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello");
        list.add(a);
        assertTrue(list.hasTweet(a));

        list.delete(a);
        assertFalse(list.hasTweet(a));
    }

    /**
     * testGetTweets tests getTweet
     */
    public void testGetTweets() {
        TweetList list = new TweetList();
        TweetList rightOrder = new TweetList();

        Date first = new GregorianCalendar(2016, Calendar.JANUARY, 1).getTime();
        Date second = new GregorianCalendar(2016, Calendar.JANUARY, 2).getTime();

        Tweet b = new NormalTweet("second", second);
        Tweet a = new NormalTweet("first", first);

        //wrong order
        list.add(b);
        list.add(a);

        //right order
        rightOrder.add(a);
        rightOrder.add(b);

        List<Tweet> chronoList = list.getTweets();

        String messageChrono = chronoList.get(0).getMessage();
        String messageRight = chronoList.get(0).getMessage();


        assertTrue(messageChrono.equals(messageRight));
    }

    /**
     * testRemoveTweet tests removeTweet
     */
    public void testRemoveTweet() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello");
        list.add(a);
        assertTrue(list.hasTweet(a));

        list.removeTweet(a);
        assertFalse(list.hasTweet(a));
    }

    /**
     * testGetCount tests getCount
     */
    public void testGetCount() {
        TweetList list = new TweetList();
        Tweet a = new NormalTweet("Hello");
        Tweet b = new NormalTweet("Hi");

        list.add(a);
        list.add(b);

        assertTrue(list.getCount() == 2);
    }


}
