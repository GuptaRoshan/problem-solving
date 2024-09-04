package neetcode150.heap;


import java.util.*;

@SuppressWarnings("all")
public class Twitter_355 {

    private static int timestamp = 0;

    private class Tweet {
        int time;
        int id;

        Tweet(int id) {
            this.time = timestamp++;
            this.id = id;
        }
    }

    Map<Integer, Set<Integer>> followers = new HashMap<>();
    Map<Integer, LinkedList<Tweet>> tweets = new HashMap<>();

    public void postTweet(int userId, int tweetId) {
        // if user not exists, create user
        if (!followers.containsKey(userId)) {
            followers.put(userId, new HashSet<>());
        }
        // Also add the user to the follower list
        followers.get(userId).add(userId);

        // Post a tweet
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new LinkedList<>());
        }

        tweets.get(userId).addFirst(new Tweet(tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!followers.containsKey(userId)) {
            return new LinkedList<>();
        }

        PriorityQueue<Tweet> feed = new PriorityQueue<>((t1, t2) -> t2.time - t1.time);

        for (int follower : followers.get(userId)) {
            if (tweets.get(follower) != null) {
                feed.addAll(tweets.get(follower));
            }
        }

        List<Integer> result = new LinkedList<>();

        while (!feed.isEmpty() && result.size() < 10) {
            result.add(feed.poll().id);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        // if follower not exists, create follower and follow itself
        if (!followers.containsKey(followerId)) {
            followers.put(followerId, new HashSet<>());
        }
        followers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        // if follower exists, remove followee
        if (followers.containsKey(followerId) && followeeId != followerId) {
            followers.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter_355 twitter = new Twitter_355();

        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        System.out.println(twitter.getNewsFeed(1));
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since
    }

}
