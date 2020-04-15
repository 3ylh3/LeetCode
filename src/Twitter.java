import java.util.*;

/**
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 *
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 * 示例:
 *
 * Twitter twitter = new Twitter();
 *
 * // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 * twitter.postTweet(1, 5);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * twitter.getNewsFeed(1);
 *
 * // 用户1关注了用户2.
 * twitter.follow(1, 2);
 *
 * // 用户2发送了一个新推文 (推文id = 6).
 * twitter.postTweet(2, 6);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 * // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 *
 * // 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * // 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
 *
 * @author yin_zhj
 * @date 2020/4/13
 */
public class Twitter {
    /**
     * 超时。。。。
     */
    /**
     * 推文对象
     */
    class Tweet {
        private int userId;
        private int tweetId;

        public Tweet(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public void setTweetId(int tweetId) {
            this.tweetId = tweetId;
        }

        public int getUserId() {
            return userId;
        }

        public int getTweetId() {
            return tweetId;
        }
    }

    /**
     * 关注map,key为useId,value为该用户关注的用户Set
     */
    private Map<Integer, Set<Integer>> follwerMap;

    /**
     * 推文列表
     */
    private List<Tweet> tweetList;

    public Twitter() {
        follwerMap = new HashMap<>();
        tweetList = new LinkedList<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        //生成新推文
        Tweet tweet = new Tweet(userId, tweetId);
        tweetList.add(tweet);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        //获取关注列表
        Set<Integer> follwerSet = follwerMap.get(userId);
        List<Integer> rs = new ArrayList<>();
        //倒序遍历推文列表，如果发文用户在关注列表内或者发文用户为自己，则将推文id加入结果list中
        int count = 1;
        for(int i = tweetList.size() - 1;i >= 0;i--) {
            if(count > 10) {
                break;
            } else {
                if (i < tweetList.size()) {
                    Tweet tweet = tweetList.get(i);
                    if ((null != follwerSet && follwerSet.contains(tweet.getUserId())) || tweet.getUserId() == userId) {
                        rs.add(tweet.tweetId);
                        count++;
                    }
                }
            }
        }
        return rs;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        //获取关注列表
        Set<Integer> set = follwerMap.get(followerId);
        if(null != set) {
            //如果非空，将关注的用户id加入
            if (!set.contains(followeeId)) {
                set.add(followeeId);
                follwerMap.put(followerId, set);
            }
        } else {
            //如果为空，则新建关注列表，将关注的用户id加入
            Set<Integer> set1 = new HashSet<>();
            set1.add(followeeId);
            follwerMap.put(followerId, set1);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        //获取关注列表
        Set<Integer> set = follwerMap.get(followerId);
        if(null == set || !set.contains(followeeId)) {
            return;
        } else {
            set.remove(followeeId);
            follwerMap.put(followerId, set);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(1, 13);
        twitter.postTweet(1, 10);
        twitter.postTweet(1, 6);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(1, 505);
        twitter.postTweet(1, 333);
        twitter.postTweet(1, 22);
        twitter.postTweet(1, 11);
       // twitter.postTweet(1, 13);
        List<Integer> list = twitter.getNewsFeed(1);
        for(Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println("");
        twitter.unfollow(1, 1);
        List<Integer> list1 = twitter.getNewsFeed(1);
        for(Integer integer : list1) {
            System.out.print(integer + " ");
        }
        System.out.println("");
        twitter.unfollow(1, 2);
        List<Integer> list2 = twitter.getNewsFeed(1);
        for(Integer integer : list2) {
            System.out.print(integer + " ");
        }
        System.out.println("");
    }
}
