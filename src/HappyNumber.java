import java.util.HashSet;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 * @author yin_zhj
 * @date 2020/4/30
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        return isHappyNumber(n, set);
    }

    public boolean isHappyNumber(int n, HashSet<Integer> set) {
        if(1 == n) {
            return true;
        }
        int rs = 0;
        while(0 != n) {
            int tmp = n % 10;
            rs += Math.pow(tmp, 2);
            n = n / 10;
        }
        if(set.contains(rs)) {
            return false;
        }
        if(1 == rs) {
            return true;
        }
        set.add(rs);
        return isHappyNumber(rs, set);
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(2));
    }
}
