package dsa.priorityqueue.questions;

import java.util.*;
/**
 * @author vkiprono
 * @created 2/22/24
 */

/**
 * LEETCODE 355. Design Twitter
 * <p>
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user,
 * and is able to see the 10 most recent tweets in the user's news feed.
 * <p>
 * Implement the Twitter class:
 * <p>
 * Twitter() Initializes your twitter object.
 * void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId
 * by the user userId. Each call to this function will be made with a unique tweetId.
 * List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news
 * feed. Each item in the news feed must be posted by users who the user followed or by the user
 * themself. Tweets must be ordered from most recent to least recent.
 * void follow(int followerId, int followeeId) The user with ID followerId started following the
 * user with ID followeeId.
 * void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing
 * the user with ID followeeId.
 */
public class Twitter {
    private static int timestamp = 0;
    private final Map<Integer, User> userMap;

    public static class Tweet {
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id) {
            this.id = id;
            time = timestamp++;
            next = null;

        }
    }

    public static class User {
        public int id;
        public Set<Integer> followed;
        public Tweet tweetHead;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id);    //Follow itself
            tweetHead = null;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            followed.remove(id);
        }

        public void post(int id) {
            Tweet newTweet = new Tweet(id);
            newTweet.next = tweetHead;
            tweetHead = newTweet;
        }
    }

    public Twitter() {
        userMap = new HashMap<>();

    }

    //Post Tweet
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            createUser(userId);
        }
        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return result;
        }
        Set<Integer> followers = userMap.get(userId).followed;
        PriorityQueue<Tweet> heap = new PriorityQueue<>(followers.size(), (a, b) -> (b.time - a.time));
        for (int follower : followers) {
            Tweet tweet = userMap.get(follower).tweetHead;
            if (tweet != null) {
                heap.add(tweet);
            }
        }
        int i = 0;
        while (!heap.isEmpty() && i < 10) {
            Tweet tweet = heap.poll();
            result.add(tweet.id);
            i++;
            if (tweet.next != null) {
                heap.add(tweet.next);
            }
        }
        return result;
    }

    //Follow - Check if both users exist
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            createUser(followerId);
        }
        if (!userMap.containsKey(followeeId)) {
            createUser(followeeId);
        }
        userMap.get(followerId).follow(followeeId);
    }

    //UnFollow - Check if both users exist
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followeeId == followerId) {
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }

    //Create new User & insert it to the map
    public void createUser(int userId) {
        User newUser = new User(userId);
        userMap.put(userId, newUser);
    }


}
